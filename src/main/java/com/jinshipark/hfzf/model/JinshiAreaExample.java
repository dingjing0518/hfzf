package com.jinshipark.hfzf.model;

import java.util.ArrayList;
import java.util.List;

public class JinshiAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JinshiAreaExample() {
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

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Integer value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Integer value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Integer value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Integer value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Integer value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Integer> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Integer> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Integer value1, Integer value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andAreaNumberIsNull() {
            addCriterion("area_number is null");
            return (Criteria) this;
        }

        public Criteria andAreaNumberIsNotNull() {
            addCriterion("area_number is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNumberEqualTo(String value) {
            addCriterion("area_number =", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberNotEqualTo(String value) {
            addCriterion("area_number <>", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberGreaterThan(String value) {
            addCriterion("area_number >", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberGreaterThanOrEqualTo(String value) {
            addCriterion("area_number >=", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberLessThan(String value) {
            addCriterion("area_number <", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberLessThanOrEqualTo(String value) {
            addCriterion("area_number <=", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberLike(String value) {
            addCriterion("area_number like", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberNotLike(String value) {
            addCriterion("area_number not like", value, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberIn(List<String> values) {
            addCriterion("area_number in", values, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberNotIn(List<String> values) {
            addCriterion("area_number not in", values, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberBetween(String value1, String value2) {
            addCriterion("area_number between", value1, value2, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andAreaNumberNotBetween(String value1, String value2) {
            addCriterion("area_number not between", value1, value2, "areaNumber");
            return (Criteria) this;
        }

        public Criteria andParkingCountIsNull() {
            addCriterion("parking_count is null");
            return (Criteria) this;
        }

        public Criteria andParkingCountIsNotNull() {
            addCriterion("parking_count is not null");
            return (Criteria) this;
        }

        public Criteria andParkingCountEqualTo(Integer value) {
            addCriterion("parking_count =", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotEqualTo(Integer value) {
            addCriterion("parking_count <>", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountGreaterThan(Integer value) {
            addCriterion("parking_count >", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_count >=", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountLessThan(Integer value) {
            addCriterion("parking_count <", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountLessThanOrEqualTo(Integer value) {
            addCriterion("parking_count <=", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountIn(List<Integer> values) {
            addCriterion("parking_count in", values, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotIn(List<Integer> values) {
            addCriterion("parking_count not in", values, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountBetween(Integer value1, Integer value2) {
            addCriterion("parking_count between", value1, value2, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_count not between", value1, value2, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountIsNull() {
            addCriterion("temporary_parking_count is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountIsNotNull() {
            addCriterion("temporary_parking_count is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountEqualTo(Integer value) {
            addCriterion("temporary_parking_count =", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountNotEqualTo(Integer value) {
            addCriterion("temporary_parking_count <>", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountGreaterThan(Integer value) {
            addCriterion("temporary_parking_count >", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("temporary_parking_count >=", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountLessThan(Integer value) {
            addCriterion("temporary_parking_count <", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountLessThanOrEqualTo(Integer value) {
            addCriterion("temporary_parking_count <=", value, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountIn(List<Integer> values) {
            addCriterion("temporary_parking_count in", values, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountNotIn(List<Integer> values) {
            addCriterion("temporary_parking_count not in", values, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountBetween(Integer value1, Integer value2) {
            addCriterion("temporary_parking_count between", value1, value2, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryParkingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("temporary_parking_count not between", value1, value2, "temporaryParkingCount");
            return (Criteria) this;
        }

        public Criteria andPayMonthIsNull() {
            addCriterion("pay_month is null");
            return (Criteria) this;
        }

        public Criteria andPayMonthIsNotNull() {
            addCriterion("pay_month is not null");
            return (Criteria) this;
        }

        public Criteria andPayMonthEqualTo(Integer value) {
            addCriterion("pay_month =", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotEqualTo(Integer value) {
            addCriterion("pay_month <>", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThan(Integer value) {
            addCriterion("pay_month >", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_month >=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThan(Integer value) {
            addCriterion("pay_month <", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThanOrEqualTo(Integer value) {
            addCriterion("pay_month <=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthIn(List<Integer> values) {
            addCriterion("pay_month in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotIn(List<Integer> values) {
            addCriterion("pay_month not in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthBetween(Integer value1, Integer value2) {
            addCriterion("pay_month between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_month not between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayQuarterIsNull() {
            addCriterion("pay_quarter is null");
            return (Criteria) this;
        }

        public Criteria andPayQuarterIsNotNull() {
            addCriterion("pay_quarter is not null");
            return (Criteria) this;
        }

        public Criteria andPayQuarterEqualTo(Integer value) {
            addCriterion("pay_quarter =", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterNotEqualTo(Integer value) {
            addCriterion("pay_quarter <>", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterGreaterThan(Integer value) {
            addCriterion("pay_quarter >", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_quarter >=", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterLessThan(Integer value) {
            addCriterion("pay_quarter <", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterLessThanOrEqualTo(Integer value) {
            addCriterion("pay_quarter <=", value, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterIn(List<Integer> values) {
            addCriterion("pay_quarter in", values, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterNotIn(List<Integer> values) {
            addCriterion("pay_quarter not in", values, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterBetween(Integer value1, Integer value2) {
            addCriterion("pay_quarter between", value1, value2, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayQuarterNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_quarter not between", value1, value2, "payQuarter");
            return (Criteria) this;
        }

        public Criteria andPayYearIsNull() {
            addCriterion("pay_year is null");
            return (Criteria) this;
        }

        public Criteria andPayYearIsNotNull() {
            addCriterion("pay_year is not null");
            return (Criteria) this;
        }

        public Criteria andPayYearEqualTo(Integer value) {
            addCriterion("pay_year =", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearNotEqualTo(Integer value) {
            addCriterion("pay_year <>", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearGreaterThan(Integer value) {
            addCriterion("pay_year >", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_year >=", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearLessThan(Integer value) {
            addCriterion("pay_year <", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearLessThanOrEqualTo(Integer value) {
            addCriterion("pay_year <=", value, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearIn(List<Integer> values) {
            addCriterion("pay_year in", values, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearNotIn(List<Integer> values) {
            addCriterion("pay_year not in", values, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearBetween(Integer value1, Integer value2) {
            addCriterion("pay_year between", value1, value2, "payYear");
            return (Criteria) this;
        }

        public Criteria andPayYearNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_year not between", value1, value2, "payYear");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarIsNull() {
            addCriterion("allow_negative_car is null");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarIsNotNull() {
            addCriterion("allow_negative_car is not null");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarEqualTo(Integer value) {
            addCriterion("allow_negative_car =", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarNotEqualTo(Integer value) {
            addCriterion("allow_negative_car <>", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarGreaterThan(Integer value) {
            addCriterion("allow_negative_car >", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_negative_car >=", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarLessThan(Integer value) {
            addCriterion("allow_negative_car <", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarLessThanOrEqualTo(Integer value) {
            addCriterion("allow_negative_car <=", value, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarIn(List<Integer> values) {
            addCriterion("allow_negative_car in", values, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarNotIn(List<Integer> values) {
            addCriterion("allow_negative_car not in", values, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarBetween(Integer value1, Integer value2) {
            addCriterion("allow_negative_car between", value1, value2, "allowNegativeCar");
            return (Criteria) this;
        }

        public Criteria andAllowNegativeCarNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_negative_car not between", value1, value2, "allowNegativeCar");
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