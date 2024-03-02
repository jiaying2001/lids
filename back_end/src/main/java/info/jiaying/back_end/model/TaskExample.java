package info.jiaying.back_end.model;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTaskUuidIsNull() {
            addCriterion("task_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTaskUuidIsNotNull() {
            addCriterion("task_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUuidEqualTo(String value) {
            addCriterion("task_uuid =", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidNotEqualTo(String value) {
            addCriterion("task_uuid <>", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidGreaterThan(String value) {
            addCriterion("task_uuid >", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidGreaterThanOrEqualTo(String value) {
            addCriterion("task_uuid >=", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidLessThan(String value) {
            addCriterion("task_uuid <", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidLessThanOrEqualTo(String value) {
            addCriterion("task_uuid <=", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidLike(String value) {
            addCriterion("task_uuid like", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidNotLike(String value) {
            addCriterion("task_uuid not like", value, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidIn(List<String> values) {
            addCriterion("task_uuid in", values, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidNotIn(List<String> values) {
            addCriterion("task_uuid not in", values, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidBetween(String value1, String value2) {
            addCriterion("task_uuid between", value1, value2, "taskUuid");
            return (Criteria) this;
        }

        public Criteria andTaskUuidNotBetween(String value1, String value2) {
            addCriterion("task_uuid not between", value1, value2, "taskUuid");
            return (Criteria) this;
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

        public Criteria andTaskStageIsNull() {
            addCriterion("task_stage is null");
            return (Criteria) this;
        }

        public Criteria andTaskStageIsNotNull() {
            addCriterion("task_stage is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStageEqualTo(String value) {
            addCriterion("task_stage =", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageNotEqualTo(String value) {
            addCriterion("task_stage <>", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageGreaterThan(String value) {
            addCriterion("task_stage >", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageGreaterThanOrEqualTo(String value) {
            addCriterion("task_stage >=", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageLessThan(String value) {
            addCriterion("task_stage <", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageLessThanOrEqualTo(String value) {
            addCriterion("task_stage <=", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageLike(String value) {
            addCriterion("task_stage like", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageNotLike(String value) {
            addCriterion("task_stage not like", value, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageIn(List<String> values) {
            addCriterion("task_stage in", values, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageNotIn(List<String> values) {
            addCriterion("task_stage not in", values, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageBetween(String value1, String value2) {
            addCriterion("task_stage between", value1, value2, "taskStage");
            return (Criteria) this;
        }

        public Criteria andTaskStageNotBetween(String value1, String value2) {
            addCriterion("task_stage not between", value1, value2, "taskStage");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumIsNull() {
            addCriterion("crt_retry_num is null");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumIsNotNull() {
            addCriterion("crt_retry_num is not null");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumEqualTo(Integer value) {
            addCriterion("crt_retry_num =", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumNotEqualTo(Integer value) {
            addCriterion("crt_retry_num <>", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumGreaterThan(Integer value) {
            addCriterion("crt_retry_num >", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("crt_retry_num >=", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumLessThan(Integer value) {
            addCriterion("crt_retry_num <", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumLessThanOrEqualTo(Integer value) {
            addCriterion("crt_retry_num <=", value, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumIn(List<Integer> values) {
            addCriterion("crt_retry_num in", values, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumNotIn(List<Integer> values) {
            addCriterion("crt_retry_num not in", values, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumBetween(Integer value1, Integer value2) {
            addCriterion("crt_retry_num between", value1, value2, "crtRetryNum");
            return (Criteria) this;
        }

        public Criteria andCrtRetryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("crt_retry_num not between", value1, value2, "crtRetryNum");
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

        public Criteria andMaxRetryIntervalIsNull() {
            addCriterion("max_retry_interval is null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalIsNotNull() {
            addCriterion("max_retry_interval is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalEqualTo(Integer value) {
            addCriterion("max_retry_interval =", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalNotEqualTo(Integer value) {
            addCriterion("max_retry_interval <>", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalGreaterThan(Integer value) {
            addCriterion("max_retry_interval >", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_retry_interval >=", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalLessThan(Integer value) {
            addCriterion("max_retry_interval <", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("max_retry_interval <=", value, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalIn(List<Integer> values) {
            addCriterion("max_retry_interval in", values, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalNotIn(List<Integer> values) {
            addCriterion("max_retry_interval not in", values, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_interval between", value1, value2, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andMaxRetryIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_interval not between", value1, value2, "maxRetryInterval");
            return (Criteria) this;
        }

        public Criteria andScheduleLogIsNull() {
            addCriterion("schedule_log is null");
            return (Criteria) this;
        }

        public Criteria andScheduleLogIsNotNull() {
            addCriterion("schedule_log is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleLogEqualTo(String value) {
            addCriterion("schedule_log =", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogNotEqualTo(String value) {
            addCriterion("schedule_log <>", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogGreaterThan(String value) {
            addCriterion("schedule_log >", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_log >=", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogLessThan(String value) {
            addCriterion("schedule_log <", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogLessThanOrEqualTo(String value) {
            addCriterion("schedule_log <=", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogLike(String value) {
            addCriterion("schedule_log like", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogNotLike(String value) {
            addCriterion("schedule_log not like", value, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogIn(List<String> values) {
            addCriterion("schedule_log in", values, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogNotIn(List<String> values) {
            addCriterion("schedule_log not in", values, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogBetween(String value1, String value2) {
            addCriterion("schedule_log between", value1, value2, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andScheduleLogNotBetween(String value1, String value2) {
            addCriterion("schedule_log not between", value1, value2, "scheduleLog");
            return (Criteria) this;
        }

        public Criteria andTaskContextIsNull() {
            addCriterion("task_context is null");
            return (Criteria) this;
        }

        public Criteria andTaskContextIsNotNull() {
            addCriterion("task_context is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContextEqualTo(String value) {
            addCriterion("task_context =", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotEqualTo(String value) {
            addCriterion("task_context <>", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextGreaterThan(String value) {
            addCriterion("task_context >", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextGreaterThanOrEqualTo(String value) {
            addCriterion("task_context >=", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLessThan(String value) {
            addCriterion("task_context <", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLessThanOrEqualTo(String value) {
            addCriterion("task_context <=", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLike(String value) {
            addCriterion("task_context like", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotLike(String value) {
            addCriterion("task_context not like", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextIn(List<String> values) {
            addCriterion("task_context in", values, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotIn(List<String> values) {
            addCriterion("task_context not in", values, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextBetween(String value1, String value2) {
            addCriterion("task_context between", value1, value2, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotBetween(String value1, String value2) {
            addCriterion("task_context not between", value1, value2, "taskContext");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Long value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Long value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Long value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Long value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Long value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Long> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Long> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Long value1, Long value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Long value1, Long value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
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