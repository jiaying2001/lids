package info.jiaying.dto;

import info.jiaying.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class CommonResponse {
    private int code;
    private String msg;
    private List<Task> data;
}
