package info.jiaying.back_end.dto;

import lombok.Data;

@Data
public class IdsParams {
    private int idsId;
    private String os;
    private String appName;
    private String accessType;
    private String typeName;
    private int typeCode;
}
