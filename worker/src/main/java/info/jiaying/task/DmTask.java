package info.jiaying.task;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import info.jiaying.http.ServerImpl;
import info.jiaying.http.ServerInterface;
import info.jiaying.log_transfer_hub.logparser.PIDLogParser;
import info.jiaying.model.LogRowData;
import info.jiaying.model.TaskContext;
import info.jiaying.task.cfg.DmConfig;
import info.jiaying.utils.convertor.ConvertUtils;
import info.jiaying.utils.file.FileUtils;
import info.jiaying.utils.parser.Parser;
import info.jiaying.utils.shell.ShellUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
public class DmTask {
    ServerInterface server = new ServerImpl();
    public TaskContext parse(String fileName, DmConfig cfg) {
        byte[] bytes = server.loadFileByFilename(fileName);
        File file = FileUtils.createFileByBytes(bytes);
        PIDLogParser parser = new PIDLogParser();
        ByteArrayOutputStream outputFile = new ByteArrayOutputStream();
        EasyExcel.read(file, LogRowData.class, new PageReadListener<LogRowData>(dataList -> {
            for (LogRowData data : dataList) {
                List<Integer> logGroup = parser.parseLogLine(Parser.RFC5424ParsePid(data.getNormalLog()), data.getNormalLog());
                if (logGroup != null) {
                    try {
                        outputFile.write(ConvertUtils.convertToBytes(logGroup));
                        outputFile.write(System.lineSeparator().getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        })).sheet().doRead();
        fileName = server.uploadFile(outputFile.toString());
        return TaskContext.create("train", new Object[]{fileName, cfg});
    }
    public TaskContext train(String fileName, DmConfig cfg) {
        return TaskContext.create("deploy", new Object[]{fileName, cfg});
    }
    public TaskContext deploy(String fileName, DmConfig cfg) {
        byte[] bytes = server.loadFileByFilename(fileName);
        File file = FileUtils.createFileByBytes(bytes);
        ShellUtils.upload("/home/ids/dm/data", file);
        ShellUtils.commitCmd(String.format("docker run -e DM_FILE_NAME=/home/ids/dm/%s -e DM_OS=%s -e DM_APP_NAME=%s -e DM_ACCESS_TYPE=%s -v /home/ids/dm/data/%s:/home/ids/dm/%s --name %s -d ids_dm", file.getName(), cfg.getOs(), cfg.getAppName(), cfg.getAccessType(), file.getName(), file.getName(), file.getName()));
        return TaskContext.TASK_END;
    }

    public static void main(String[] args) {
        DmTask t = new DmTask();
        DmConfig cfg = new DmConfig();
        cfg.setOs("linux");
        cfg.setAppName("sshd");
        cfg.setAccessType("public");
        t.deploy("test", cfg);
    }
}
