package info.jiaying.back_end.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TaskMetaCfg implements Serializable {
    @ApiModelProperty(value = "任务类型")
    private String taskType;

    @ApiModelProperty(value = "一次拉取多少个任务")
    private Integer scheduleLimit;

    private Integer scheduleInterval;

    @ApiModelProperty(value = "处于执行中的最大时间")
    private Integer maxProcessingTime;

    @ApiModelProperty(value = "最大重试次数")
    private Integer maxRetryNum;

    @ApiModelProperty(value = "重试间隔")
    private Integer retryInterval;

    private Long createTime;

    private Long modifyTime;

    private static final long serialVersionUID = 1L;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getScheduleLimit() {
        return scheduleLimit;
    }

    public void setScheduleLimit(Integer scheduleLimit) {
        this.scheduleLimit = scheduleLimit;
    }

    public Integer getScheduleInterval() {
        return scheduleInterval;
    }

    public void setScheduleInterval(Integer scheduleInterval) {
        this.scheduleInterval = scheduleInterval;
    }

    public Integer getMaxProcessingTime() {
        return maxProcessingTime;
    }

    public void setMaxProcessingTime(Integer maxProcessingTime) {
        this.maxProcessingTime = maxProcessingTime;
    }

    public Integer getMaxRetryNum() {
        return maxRetryNum;
    }

    public void setMaxRetryNum(Integer maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskType=").append(taskType);
        sb.append(", scheduleLimit=").append(scheduleLimit);
        sb.append(", scheduleInterval=").append(scheduleInterval);
        sb.append(", maxProcessingTime=").append(maxProcessingTime);
        sb.append(", maxRetryNum=").append(maxRetryNum);
        sb.append(", retryInterval=").append(retryInterval);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}