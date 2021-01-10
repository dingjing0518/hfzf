package com.jinshipark.hfzf.model;

import java.util.ArrayList;
import java.util.List;

public class JinshiparkApakeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JinshiparkApakeyExample() {
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

        public Criteria andParknameIsNull() {
            addCriterion("ParkName is null");
            return (Criteria) this;
        }

        public Criteria andParknameIsNotNull() {
            addCriterion("ParkName is not null");
            return (Criteria) this;
        }

        public Criteria andParknameEqualTo(String value) {
            addCriterion("ParkName =", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotEqualTo(String value) {
            addCriterion("ParkName <>", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameGreaterThan(String value) {
            addCriterion("ParkName >", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameGreaterThanOrEqualTo(String value) {
            addCriterion("ParkName >=", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLessThan(String value) {
            addCriterion("ParkName <", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLessThanOrEqualTo(String value) {
            addCriterion("ParkName <=", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLike(String value) {
            addCriterion("ParkName like", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotLike(String value) {
            addCriterion("ParkName not like", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameIn(List<String> values) {
            addCriterion("ParkName in", values, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotIn(List<String> values) {
            addCriterion("ParkName not in", values, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameBetween(String value1, String value2) {
            addCriterion("ParkName between", value1, value2, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotBetween(String value1, String value2) {
            addCriterion("ParkName not between", value1, value2, "parkname");
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

        public Criteria andAppidIsNull() {
            addCriterion("AppID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("AppID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("AppID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("AppID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("AppID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("AppID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("AppID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("AppID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("AppID like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("AppID not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("AppID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("AppID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("AppID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("AppID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyIsNull() {
            addCriterion("RSAPrivateKey is null");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyIsNotNull() {
            addCriterion("RSAPrivateKey is not null");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyEqualTo(String value) {
            addCriterion("RSAPrivateKey =", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyNotEqualTo(String value) {
            addCriterion("RSAPrivateKey <>", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyGreaterThan(String value) {
            addCriterion("RSAPrivateKey >", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyGreaterThanOrEqualTo(String value) {
            addCriterion("RSAPrivateKey >=", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyLessThan(String value) {
            addCriterion("RSAPrivateKey <", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyLessThanOrEqualTo(String value) {
            addCriterion("RSAPrivateKey <=", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyLike(String value) {
            addCriterion("RSAPrivateKey like", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyNotLike(String value) {
            addCriterion("RSAPrivateKey not like", value, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyIn(List<String> values) {
            addCriterion("RSAPrivateKey in", values, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyNotIn(List<String> values) {
            addCriterion("RSAPrivateKey not in", values, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyBetween(String value1, String value2) {
            addCriterion("RSAPrivateKey between", value1, value2, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andRsaprivatekeyNotBetween(String value1, String value2) {
            addCriterion("RSAPrivateKey not between", value1, value2, "rsaprivatekey");
            return (Criteria) this;
        }

        public Criteria andApikeyliveIsNull() {
            addCriterion("ApiKeyLive is null");
            return (Criteria) this;
        }

        public Criteria andApikeyliveIsNotNull() {
            addCriterion("ApiKeyLive is not null");
            return (Criteria) this;
        }

        public Criteria andApikeyliveEqualTo(String value) {
            addCriterion("ApiKeyLive =", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveNotEqualTo(String value) {
            addCriterion("ApiKeyLive <>", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveGreaterThan(String value) {
            addCriterion("ApiKeyLive >", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveGreaterThanOrEqualTo(String value) {
            addCriterion("ApiKeyLive >=", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveLessThan(String value) {
            addCriterion("ApiKeyLive <", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveLessThanOrEqualTo(String value) {
            addCriterion("ApiKeyLive <=", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveLike(String value) {
            addCriterion("ApiKeyLive like", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveNotLike(String value) {
            addCriterion("ApiKeyLive not like", value, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveIn(List<String> values) {
            addCriterion("ApiKeyLive in", values, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveNotIn(List<String> values) {
            addCriterion("ApiKeyLive not in", values, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveBetween(String value1, String value2) {
            addCriterion("ApiKeyLive between", value1, value2, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeyliveNotBetween(String value1, String value2) {
            addCriterion("ApiKeyLive not between", value1, value2, "apikeylive");
            return (Criteria) this;
        }

        public Criteria andApikeytestIsNull() {
            addCriterion("ApiKeyTest is null");
            return (Criteria) this;
        }

        public Criteria andApikeytestIsNotNull() {
            addCriterion("ApiKeyTest is not null");
            return (Criteria) this;
        }

        public Criteria andApikeytestEqualTo(String value) {
            addCriterion("ApiKeyTest =", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestNotEqualTo(String value) {
            addCriterion("ApiKeyTest <>", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestGreaterThan(String value) {
            addCriterion("ApiKeyTest >", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestGreaterThanOrEqualTo(String value) {
            addCriterion("ApiKeyTest >=", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestLessThan(String value) {
            addCriterion("ApiKeyTest <", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestLessThanOrEqualTo(String value) {
            addCriterion("ApiKeyTest <=", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestLike(String value) {
            addCriterion("ApiKeyTest like", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestNotLike(String value) {
            addCriterion("ApiKeyTest not like", value, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestIn(List<String> values) {
            addCriterion("ApiKeyTest in", values, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestNotIn(List<String> values) {
            addCriterion("ApiKeyTest not in", values, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestBetween(String value1, String value2) {
            addCriterion("ApiKeyTest between", value1, value2, "apikeytest");
            return (Criteria) this;
        }

        public Criteria andApikeytestNotBetween(String value1, String value2) {
            addCriterion("ApiKeyTest not between", value1, value2, "apikeytest");
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