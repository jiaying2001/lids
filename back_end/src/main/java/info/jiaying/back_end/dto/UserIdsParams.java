package info.jiaying.back_end.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserIdsParams {
    private int userId;
    @JsonProperty("ids_id")
    private int idsId;
}
