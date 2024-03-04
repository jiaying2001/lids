package info.jiaying.back_end.dto;

import lombok.Data;

@Data
public class TaskParams {
    private String user_id;

    private String task_type="";

    private String task_stage="";

    private String schedule_log="";

    private String task_context="";

    private String file_name="";
}
