package info.jiaying.back_end.service.impl;


import io.netty.util.internal.ReflectionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {
    @InjectMocks
    private info.jiaying.back_end.service.impl.FileServiceImpl underTest;

    @Nested
    class WhenSaving {
        @Mock
        private MultipartFile file;

        @BeforeEach
        void setup() throws IOException {
            Mockito.when(file.getBytes()).thenReturn("Hello world111".getBytes());
        }

        @Test
        public void shouldSaveToCorrectFilePath() throws IOException {
            underTest.save(file);
        }
    }

    @Nested
    class WhenGetting {
        private final String FILE_NAME = "FILE_NAME";

        @BeforeEach
        void setup() {
        }
    }
}
