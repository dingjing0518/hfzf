package com.jinshipark.hfzf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JinshiparkCamerasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JinshiparkCamerasExample() {
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

        public Criteria andCameranameIsNull() {
            addCriterion("CameraName is null");
            return (Criteria) this;
        }

        public Criteria andCameranameIsNotNull() {
            addCriterion("CameraName is not null");
            return (Criteria) this;
        }

        public Criteria andCameranameEqualTo(String value) {
            addCriterion("CameraName =", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameNotEqualTo(String value) {
            addCriterion("CameraName <>", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameGreaterThan(String value) {
            addCriterion("CameraName >", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameGreaterThanOrEqualTo(String value) {
            addCriterion("CameraName >=", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameLessThan(String value) {
            addCriterion("CameraName <", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameLessThanOrEqualTo(String value) {
            addCriterion("CameraName <=", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameLike(String value) {
            addCriterion("CameraName like", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameNotLike(String value) {
            addCriterion("CameraName not like", value, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameIn(List<String> values) {
            addCriterion("CameraName in", values, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameNotIn(List<String> values) {
            addCriterion("CameraName not in", values, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameBetween(String value1, String value2) {
            addCriterion("CameraName between", value1, value2, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameranameNotBetween(String value1, String value2) {
            addCriterion("CameraName not between", value1, value2, "cameraname");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNull() {
            addCriterion("CameraID is null");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNotNull() {
            addCriterion("CameraID is not null");
            return (Criteria) this;
        }

        public Criteria andCameraidEqualTo(String value) {
            addCriterion("CameraID =", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotEqualTo(String value) {
            addCriterion("CameraID <>", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThan(String value) {
            addCriterion("CameraID >", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThanOrEqualTo(String value) {
            addCriterion("CameraID >=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThan(String value) {
            addCriterion("CameraID <", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThanOrEqualTo(String value) {
            addCriterion("CameraID <=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLike(String value) {
            addCriterion("CameraID like", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotLike(String value) {
            addCriterion("CameraID not like", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidIn(List<String> values) {
            addCriterion("CameraID in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotIn(List<String> values) {
            addCriterion("CameraID not in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidBetween(String value1, String value2) {
            addCriterion("CameraID between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotBetween(String value1, String value2) {
            addCriterion("CameraID not between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andInoroutIsNull() {
            addCriterion("InOrOut is null");
            return (Criteria) this;
        }

        public Criteria andInoroutIsNotNull() {
            addCriterion("InOrOut is not null");
            return (Criteria) this;
        }

        public Criteria andInoroutEqualTo(String value) {
            addCriterion("InOrOut =", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutNotEqualTo(String value) {
            addCriterion("InOrOut <>", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutGreaterThan(String value) {
            addCriterion("InOrOut >", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutGreaterThanOrEqualTo(String value) {
            addCriterion("InOrOut >=", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutLessThan(String value) {
            addCriterion("InOrOut <", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutLessThanOrEqualTo(String value) {
            addCriterion("InOrOut <=", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutLike(String value) {
            addCriterion("InOrOut like", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutNotLike(String value) {
            addCriterion("InOrOut not like", value, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutIn(List<String> values) {
            addCriterion("InOrOut in", values, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutNotIn(List<String> values) {
            addCriterion("InOrOut not in", values, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutBetween(String value1, String value2) {
            addCriterion("InOrOut between", value1, value2, "inorout");
            return (Criteria) this;
        }

        public Criteria andInoroutNotBetween(String value1, String value2) {
            addCriterion("InOrOut not between", value1, value2, "inorout");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andParkidIsNull() {
            addCriterion("ParkID is null");
            return (Criteria) this;
        }

        public Criteria andParkidIsNotNull() {
            addCriterion("ParkID is not null");
            return (Criteria) this;
        }

        public Criteria andParkidEqualTo(String value) {
            addCriterion("ParkID =", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotEqualTo(String value) {
            addCriterion("ParkID <>", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThan(String value) {
            addCriterion("ParkID >", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThanOrEqualTo(String value) {
            addCriterion("ParkID >=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThan(String value) {
            addCriterion("ParkID <", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThanOrEqualTo(String value) {
            addCriterion("ParkID <=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLike(String value) {
            addCriterion("ParkID like", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotLike(String value) {
            addCriterion("ParkID not like", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidIn(List<String> values) {
            addCriterion("ParkID in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotIn(List<String> values) {
            addCriterion("ParkID not in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidBetween(String value1, String value2) {
            addCriterion("ParkID between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotBetween(String value1, String value2) {
            addCriterion("ParkID not between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNull() {
            addCriterion("AreaName is null");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNotNull() {
            addCriterion("AreaName is not null");
            return (Criteria) this;
        }

        public Criteria andAreanameEqualTo(String value) {
            addCriterion("AreaName =", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotEqualTo(String value) {
            addCriterion("AreaName <>", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThan(String value) {
            addCriterion("AreaName >", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThanOrEqualTo(String value) {
            addCriterion("AreaName >=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThan(String value) {
            addCriterion("AreaName <", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThanOrEqualTo(String value) {
            addCriterion("AreaName <=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLike(String value) {
            addCriterion("AreaName like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotLike(String value) {
            addCriterion("AreaName not like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameIn(List<String> values) {
            addCriterion("AreaName in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotIn(List<String> values) {
            addCriterion("AreaName not in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameBetween(String value1, String value2) {
            addCriterion("AreaName between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotBetween(String value1, String value2) {
            addCriterion("AreaName not between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
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