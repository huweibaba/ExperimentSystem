package com.byk.experimentsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Option_logExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Option_logExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOptionIsNull() {
            addCriterion("option is null");
            return (Criteria) this;
        }

        public Criteria andOptionIsNotNull() {
            addCriterion("option is not null");
            return (Criteria) this;
        }

        public Criteria andOptionEqualTo(String value) {
            addCriterion("option =", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotEqualTo(String value) {
            addCriterion("option <>", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThan(String value) {
            addCriterion("option >", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThanOrEqualTo(String value) {
            addCriterion("option >=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThan(String value) {
            addCriterion("option <", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThanOrEqualTo(String value) {
            addCriterion("option <=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLike(String value) {
            addCriterion("option like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotLike(String value) {
            addCriterion("option not like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionIn(List<String> values) {
            addCriterion("option in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotIn(List<String> values) {
            addCriterion("option not in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionBetween(String value1, String value2) {
            addCriterion("option between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotBetween(String value1, String value2) {
            addCriterion("option not between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andSqlStrIsNull() {
            addCriterion("sql_str is null");
            return (Criteria) this;
        }

        public Criteria andSqlStrIsNotNull() {
            addCriterion("sql_str is not null");
            return (Criteria) this;
        }

        public Criteria andSqlStrEqualTo(String value) {
            addCriterion("sql_str =", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrNotEqualTo(String value) {
            addCriterion("sql_str <>", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrGreaterThan(String value) {
            addCriterion("sql_str >", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrGreaterThanOrEqualTo(String value) {
            addCriterion("sql_str >=", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrLessThan(String value) {
            addCriterion("sql_str <", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrLessThanOrEqualTo(String value) {
            addCriterion("sql_str <=", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrLike(String value) {
            addCriterion("sql_str like", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrNotLike(String value) {
            addCriterion("sql_str not like", value, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrIn(List<String> values) {
            addCriterion("sql_str in", values, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrNotIn(List<String> values) {
            addCriterion("sql_str not in", values, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrBetween(String value1, String value2) {
            addCriterion("sql_str between", value1, value2, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andSqlStrNotBetween(String value1, String value2) {
            addCriterion("sql_str not between", value1, value2, "sqlStr");
            return (Criteria) this;
        }

        public Criteria andOptTableNameIsNull() {
            addCriterion("opt_table_name is null");
            return (Criteria) this;
        }

        public Criteria andOptTableNameIsNotNull() {
            addCriterion("opt_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andOptTableNameEqualTo(String value) {
            addCriterion("opt_table_name =", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameNotEqualTo(String value) {
            addCriterion("opt_table_name <>", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameGreaterThan(String value) {
            addCriterion("opt_table_name >", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("opt_table_name >=", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameLessThan(String value) {
            addCriterion("opt_table_name <", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameLessThanOrEqualTo(String value) {
            addCriterion("opt_table_name <=", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameLike(String value) {
            addCriterion("opt_table_name like", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameNotLike(String value) {
            addCriterion("opt_table_name not like", value, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameIn(List<String> values) {
            addCriterion("opt_table_name in", values, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameNotIn(List<String> values) {
            addCriterion("opt_table_name not in", values, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameBetween(String value1, String value2) {
            addCriterion("opt_table_name between", value1, value2, "optTableName");
            return (Criteria) this;
        }

        public Criteria andOptTableNameNotBetween(String value1, String value2) {
            addCriterion("opt_table_name not between", value1, value2, "optTableName");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNull() {
            addCriterion("createdAt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNotNull() {
            addCriterion("createdAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedatEqualTo(Date value) {
            addCriterion("createdAt =", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotEqualTo(Date value) {
            addCriterion("createdAt <>", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThan(Date value) {
            addCriterion("createdAt >", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("createdAt >=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThan(Date value) {
            addCriterion("createdAt <", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThanOrEqualTo(Date value) {
            addCriterion("createdAt <=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatIn(List<Date> values) {
            addCriterion("createdAt in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotIn(List<Date> values) {
            addCriterion("createdAt not in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatBetween(Date value1, Date value2) {
            addCriterion("createdAt between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotBetween(Date value1, Date value2) {
            addCriterion("createdAt not between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andOptUidIsNull() {
            addCriterion("opt_uid is null");
            return (Criteria) this;
        }

        public Criteria andOptUidIsNotNull() {
            addCriterion("opt_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOptUidEqualTo(Integer value) {
            addCriterion("opt_uid =", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidNotEqualTo(Integer value) {
            addCriterion("opt_uid <>", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidGreaterThan(Integer value) {
            addCriterion("opt_uid >", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_uid >=", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidLessThan(Integer value) {
            addCriterion("opt_uid <", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidLessThanOrEqualTo(Integer value) {
            addCriterion("opt_uid <=", value, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidIn(List<Integer> values) {
            addCriterion("opt_uid in", values, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidNotIn(List<Integer> values) {
            addCriterion("opt_uid not in", values, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidBetween(Integer value1, Integer value2) {
            addCriterion("opt_uid between", value1, value2, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptUidNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_uid not between", value1, value2, "optUid");
            return (Criteria) this;
        }

        public Criteria andOptTidIsNull() {
            addCriterion("opt_tid is null");
            return (Criteria) this;
        }

        public Criteria andOptTidIsNotNull() {
            addCriterion("opt_tid is not null");
            return (Criteria) this;
        }

        public Criteria andOptTidEqualTo(Integer value) {
            addCriterion("opt_tid =", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidNotEqualTo(Integer value) {
            addCriterion("opt_tid <>", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidGreaterThan(Integer value) {
            addCriterion("opt_tid >", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_tid >=", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidLessThan(Integer value) {
            addCriterion("opt_tid <", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidLessThanOrEqualTo(Integer value) {
            addCriterion("opt_tid <=", value, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidIn(List<Integer> values) {
            addCriterion("opt_tid in", values, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidNotIn(List<Integer> values) {
            addCriterion("opt_tid not in", values, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidBetween(Integer value1, Integer value2) {
            addCriterion("opt_tid between", value1, value2, "optTid");
            return (Criteria) this;
        }

        public Criteria andOptTidNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_tid not between", value1, value2, "optTid");
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