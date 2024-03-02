package info.jiaying.dto;

import lombok.Data;

@Data
public class AbstractResponse {
    private int code;
    private String msg;
}
