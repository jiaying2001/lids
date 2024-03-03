package info.jiaying.utils.shell;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.*;

import java.io.*;

public class ShellUtils {
    //新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
    private static Session session = JschUtil.getSession("jiaying.info", 22, "root", "Hjy20011222.");

    public static void commitCmd(String cmd) {
        ChannelExec c = null;
        try {
            c = (ChannelExec) session.openChannel("exec");
            c.setCommand(cmd);
            c.connect();
        } catch (JSchException e) {
            throw new RuntimeException(e);
        } finally {
            if (c != null) {
                c.disconnect();
            }
        }
    }

    public static void upload(String dir, File file) {
        ChannelSftp c = null;
        try {
            c = (ChannelSftp) session.openChannel("sftp");
            c.connect();
            c.cd(dir);
            c.put(new FileInputStream(file), file.getName());
        } catch (JSchException | SftpException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            c.disconnect();
        }
    }

    public static void main(String[] args) {
        commitCmd("ls /home");
    }
}
