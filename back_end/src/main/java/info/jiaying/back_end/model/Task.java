package info.jiaying.back_end.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Task implements Serializable {
    private Integer taskId;

    private String userId;

    private String taskUuid;

    private String taskType;

    private String taskStage;

    private int status;

    @ApiModelProperty(value = "优先级")
    private int priority;

    @ApiModelProperty(value = "已经重试几次了")
    private int crtRetryNum;

    @ApiModelProperty(value = "最大能重试几次")
    private int maxRetryNum;

    @ApiModelProperty(value = "最大重试间隔")
    private int maxRetryInterval;

    @ApiModelProperty(value = "调度信息记录")
    private String scheduleLog;

    @ApiModelProperty(value = "任务上下文，用户自定义")
    private String taskContext;

    @ApiModelProperty(value = "训练数据文件名")
    private String fileName;

    @ApiModelProperty(value = "调度时间，越小调度越优先")
    private Long orderTime;

    private Long createTime;

    private Long modifyTime;

    private static final long serialVersionUID = 1L;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStage() {
        return taskStage;
    }

    public void setTaskStage(String taskStage) {
        this.taskStage = taskStage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCrtRetryNum() {
        return crtRetryNum;
    }

    public void setCrtRetryNum(int crtRetryNum) {
        this.crtRetryNum = crtRetryNum;
    }

    public int getMaxRetryNum() {
        return maxRetryNum;
    }

    public void setMaxRetryNum(int maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }

    public int getMaxRetryInterval() {
        return maxRetryInterval;
    }

    public void setMaxRetryInterval(int maxRetryInterval) {
        this.maxRetryInterval = maxRetryInterval;
    }

    public String getScheduleLog() {
        return scheduleLog;
    }

    public void setScheduleLog(String scheduleLog) {
        this.scheduleLog = scheduleLog;
    }

    public String getTaskContext() {
        return taskContext;
    }

    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
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
        sb.append(", taskId=").append(taskId);
        sb.append(", userId=").append(userId);
        sb.append(", taskUuid=").append(taskUuid);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskStage=").append(taskStage);
        sb.append(", status=").append(status);
        sb.append(", priority=").append(priority);
        sb.append(", crtRetryNum=").append(crtRetryNum);
        sb.append(", maxRetryNum=").append(maxRetryNum);
        sb.append(", maxRetryInterval=").append(maxRetryInterval);
        sb.append(", scheduleLog=").append(scheduleLog);
        sb.append(", taskContext=").append(taskContext);
        sb.append(", fileName=").append(fileName);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}