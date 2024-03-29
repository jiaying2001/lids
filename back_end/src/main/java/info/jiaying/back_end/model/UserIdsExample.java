package info.jiaying.back_end.model;

import java.util.ArrayList;
import java.util.List;

public class UserIdsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserIdsExample() {
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

        public Criteria andUserIdsIdIsNull() {
            addCriterion("user_ids_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdIsNotNull() {
            addCriterion("user_ids_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdEqualTo(Integer value) {
            addCriterion("user_ids_id =", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdNotEqualTo(Integer value) {
            addCriterion("user_ids_id <>", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdGreaterThan(Integer value) {
            addCriterion("user_ids_id >", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_ids_id >=", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdLessThan(Integer value) {
            addCriterion("user_ids_id <", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_ids_id <=", value, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdIn(List<Integer> values) {
            addCriterion("user_ids_id in", values, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdNotIn(List<Integer> values) {
            addCriterion("user_ids_id not in", values, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdBetween(Integer value1, Integer value2) {
            addCriterion("user_ids_id between", value1, value2, "userIdsId");
            return (Criteria) this;
        }

        public Criteria andUserIdsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_ids_id not between", value1, value2, "userIdsId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIdsIdIsNull() {
            addCriterion("ids_id is null");
            return (Criteria) this;
        }

        public Criteria andIdsIdIsNotNull() {
            addCriterion("ids_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdsIdEqualTo(Integer value) {
            addCriterion("ids_id =", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdNotEqualTo(Integer value) {
            addCriterion("ids_id <>", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdGreaterThan(Integer value) {
            addCriterion("ids_id >", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ids_id >=", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdLessThan(Integer value) {
            addCriterion("ids_id <", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ids_id <=", value, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdIn(List<Integer> values) {
            addCriterion("ids_id in", values, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdNotIn(List<Integer> values) {
            addCriterion("ids_id not in", values, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdBetween(Integer value1, Integer value2) {
            addCriterion("ids_id between", value1, value2, "idsId");
            return (Criteria) this;
        }

        public Criteria andIdsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ids_id not between", value1, value2, "idsId");
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