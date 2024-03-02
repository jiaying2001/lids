package info.jiaying.back_end.model;

import java.util.ArrayList;
import java.util.List;

public class TaskMetaCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskMetaCfgExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitIsNull() {
            addCriterion("schedule_limit is null");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitIsNotNull() {
            addCriterion("schedule_limit is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitEqualTo(Integer value) {
            addCriterion("schedule_limit =", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitNotEqualTo(Integer value) {
            addCriterion("schedule_limit <>", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitGreaterThan(Integer value) {
            addCriterion("schedule_limit >", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_limit >=", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitLessThan(Integer value) {
            addCriterion("schedule_limit <", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_limit <=", value, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitIn(List<Integer> values) {
            addCriterion("schedule_limit in", values, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitNotIn(List<Integer> values) {
            addCriterion("schedule_limit not in", values, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitBetween(Integer value1, Integer value2) {
            addCriterion("schedule_limit between", value1, value2, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_limit not between", value1, value2, "scheduleLimit");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalIsNull() {
            addCriterion("schedule_interval is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalIsNotNull() {
            addCriterion("schedule_interval is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalEqualTo(Integer value) {
            addCriterion("schedule_interval =", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalNotEqualTo(Integer value) {
            addCriterion("schedule_interval <>", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalGreaterThan(Integer value) {
            addCriterion("schedule_interval >", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_interval >=", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalLessThan(Integer value) {
            addCriterion("schedule_interval <", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_interval <=", value, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalIn(List<Integer> values) {
            addCriterion("schedule_interval in", values, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalNotIn(List<Integer> values) {
            addCriterion("schedule_interval not in", values, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalBetween(Integer value1, Integer value2) {
            addCriterion("schedule_interval between", value1, value2, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_interval not between", value1, value2, "scheduleInterval");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIsNull() {
            addCriterion("max_processing_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIsNotNull() {
            addCriterion("max_processing_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeEqualTo(Integer value) {
            addCriterion("max_processing_time =", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotEqualTo(Integer value) {
            addCriterion("max_processing_time <>", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeGreaterThan(Integer value) {
            addCriterion("max_processing_time >", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_processing_time >=", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeLessThan(Integer value) {
            addCriterion("max_processing_time <", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("max_processing_time <=", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIn(List<Integer> values) {
            addCriterion("max_processing_time in", values, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotIn(List<Integer> values) {
            addCriterion("max_processing_time not in", values, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeBetween(Integer value1, Integer value2) {
            addCriterion("max_processing_time between", value1, value2, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("max_processing_time not between", value1, value2, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIsNull() {
            addCriterion("max_retry_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIsNotNull() {
            addCriterion("max_retry_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumEqualTo(Integer value) {
            addCriterion("max_retry_num =", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotEqualTo(Integer value) {
            addCriterion("max_retry_num <>", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumGreaterThan(Integer value) {
            addCriterion("max_retry_num >", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_retry_num >=", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumLessThan(Integer value) {
            addCriterion("max_retry_num <", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_retry_num <=", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIn(List<Integer> values) {
            addCriterion("max_retry_num in", values, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotIn(List<Integer> values) {
            addCriterion("max_retry_num not in", values, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_num between", value1, value2, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_num not between", value1, value2, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalIsNull() {
            addCriterion("retry_interval is null");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalIsNotNull() {
            addCriterion("retry_interval is not null");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalEqualTo(Integer value) {
            addCriterion("retry_interval =", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalNotEqualTo(Integer value) {
            addCriterion("retry_interval <>", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalGreaterThan(Integer value) {
            addCriterion("retry_interval >", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_interval >=", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalLessThan(Integer value) {
            addCriterion("retry_interval <", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("retry_interval <=", value, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalIn(List<Integer> values) {
            addCriterion("retry_interval in", values, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalNotIn(List<Integer> values) {
            addCriterion("retry_interval not in", values, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalBetween(Integer value1, Integer value2) {
            addCriterion("retry_interval between", value1, value2, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andRetryIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_interval not between", value1, value2, "retryInterval");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Long value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Long value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Long value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Long value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Long value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Long> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Long> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Long value1, Long value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Long value1, Long value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}