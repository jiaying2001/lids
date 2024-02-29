package info.jiaying.log_transfer_hub.logparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DrainLogParserTests {
    private DrainLogParser DUT = new DrainLogParser(4, 3, 0.9F);
    String log = "Dec  3 03:12:01 VM-4-2-centos kernel: device eth0 left promiscuous mode";
    @Test
    public void preprocessTest() {
        Assertions.assertArrayEquals(new String[]{
                "<*>",
                "<*>",
                "<*>",
                "VM-4-2-centos",
                "kernel:",
                "device",
                "eth0",
                "left",
                "promiscuous",
                "mode"
        },
                DUT.preprocess(log));
    }

    @Test
    public void parseLogLineTest() {
        System.out.println(DUT.parseLogLine(log));
    }
}
