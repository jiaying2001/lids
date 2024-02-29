package info.jiaying.log_transfer_hub.message;

import cn.hutool.core.util.IdUtil;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LogTransactionMessage {
    private String uuid = IdUtil.simpleUUID();
    private List<Integer> logGroup;
}
