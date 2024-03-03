package info.jiaying.utils.file;

import cn.hutool.core.lang.UUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtils {
    public static File createFileByBytes(byte[] bytes) {
        // To avoid write bytes to disk, load bytes to buffer for EasyExcel read
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        try {
            File tempFile = File.createTempFile("./tmp/" + UUID.randomUUID().toString(), "");
            // Write the content of ByteBuffer to the temporary file
            try (FileChannel channel = new FileOutputStream(tempFile).getChannel()) {
                channel.write(buffer);
            }
            // Now you can use tempFile as needed
            return tempFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
