package info.jiaying.enums;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

public enum TaskStatus {
        // 待执行
        PENDING(0x01),
        // 执行中
        EXECUTING(0x02),
        // 执行成功
        SUCCESS(0x04),
        // 执行失败
        FAIL(0x08);

        private TaskStatus(int status) {
            this.status = status;
        }

        @Getter
        @Setter
        private int status;
}
