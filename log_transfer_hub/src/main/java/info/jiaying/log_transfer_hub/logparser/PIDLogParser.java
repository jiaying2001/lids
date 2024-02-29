package info.jiaying.log_transfer_hub.logparser;

import cn.hutool.core.io.resource.ResourceUtil;
import com.alibaba.fastjson2.JSONObject;
import info.jiaying.log_transfer_hub.message.LogTransactionMessage;
import info.jiaying.log_transfer_hub.util.kafka.client.KafkaClient;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIDLogParser {
    private int pid = -1;
   List<Integer> logGroup = new ArrayList<>();
   DrainLogParser eventIdParser = new DrainLogParser(5, 5, 0.60F);

   public static void main(String[] args) {
   }
    public List<Integer> parseLogLine (int pid, String log) {
        List<Integer> copy = null;
        if (pid == -1) return null;
        if (this.pid == -1) {
            this.pid = pid;
        } else if (pid != this.pid) {
            copy = new ArrayList<>(logGroup) ;
            logGroup.clear();
            this.pid = pid;
        }
        logGroup.add(eventIdParser.parseLogLine(log));
        return copy;
    }

    public void write() {
//        String filePath = "output.txt";
//
//        try (FileWriter writer = new FileWriter(filePath, true)) {
//           for (Integer i: logGroup) {
//               writer.write(i.toString() + " ");
//           }
//           writer.write(System.lineSeparator());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        KafkaClient.send("ssh_transaction", LogTransactionMessage.builder().logGroup(logGroup).build());
    }

//    public int extractPid(String log) {
//        Matcher matcher = PID_PATTERN.matcher(log);
//        if (matcher.find()) {
//            String identifier = matcher.group(0);
//            return Integer.parseInt(identifier.substring(5, identifier.length()-2));
//        }
//        return -1;
//    }
}
