package info.jiaying.back_end.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Ids implements Serializable {
    @JsonProperty("ids_id")
    private Integer idsId;

    private String os;

    @JsonProperty("app_name")
    private String appName;

    @JsonProperty("access_type")
    @ApiModelProperty(value = "public or private access")
    private Integer accessType;

    @JsonProperty("type_name")
    @ApiModelProperty(value = "indicates which method applied in the ids")
    private String typeName;

    @JsonProperty("type_code")
    private Integer typeCode;

    private static final long serialVersionUID = 1L;

    public Integer getIdsId() {
        return idsId;
    }

    public void setIdsId(Integer idsId) {
        this.idsId = idsId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idsId=").append(idsId);
        sb.append(", os=").append(os);
        sb.append(", appName=").append(appName);
        sb.append(", accessType=").append(accessType);
        sb.append(", typeName=").append(typeName);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}