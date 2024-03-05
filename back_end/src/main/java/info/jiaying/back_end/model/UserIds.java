package info.jiaying.back_end.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UserIds implements Serializable {
    private Integer userIdsId;

    private Integer userId;

    private Integer idsId;

    private static final long serialVersionUID = 1L;

    public Integer getUserIdsId() {
        return userIdsId;
    }

    public void setUserIdsId(Integer userIdsId) {
        this.userIdsId = userIdsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIdsId() {
        return idsId;
    }

    public void setIdsId(Integer idsId) {
        this.idsId = idsId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userIdsId=").append(userIdsId);
        sb.append(", userId=").append(userId);
        sb.append(", idsId=").append(idsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}