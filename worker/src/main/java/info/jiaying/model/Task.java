package info.jiaying.model;

import lombok.Data;

@Data
public class Task {
    private Long taskId;

    private String userId; //NOT NULL DEFAULT '',

    private String taskUuid; // NOT NULL DEFAULT '',

    private String taskType; //NOT NULL DEFAULT '',  存储任务的全类名

    private String taskStage; //NOT NULL DEFAULT '', 存储任务阶段信息

    private int status; //tinyint(3) unsigned NOT NULL DEFAULT '0',

    private long orderTime;

    private int priority;

    private int crtRetryNum; //NOT NULL DEFAULT '0' COMMENT '已经重试几次了',

    private int maxRetryNum; //NOT NULL DEFAULT '0' COMMENT '最大能重试几次',

    private int maxRetryInterval;// int(11) NOT NULL DEFAULT '0' COMMENT '最大重试间隔',

    private String scheduleLog;// varchar(4096) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '调度信息记录',

    private String taskContext;// varchar(8192) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '任务上下文，用户自定义',

    private Long createTime;// datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,

    private Long modifyTime;// datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    private  String fileName;


}
