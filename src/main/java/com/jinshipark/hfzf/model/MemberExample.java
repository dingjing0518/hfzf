package com.jinshipark.hfzf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Date value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Date value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Date value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Date value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Date> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Date> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Date value1, Date value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdIsNull() {
            addCriterion("lincense_plate_id is null");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdIsNotNull() {
            addCriterion("lincense_plate_id is not null");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdEqualTo(String value) {
            addCriterion("lincense_plate_id =", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdNotEqualTo(String value) {
            addCriterion("lincense_plate_id <>", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdGreaterThan(String value) {
            addCriterion("lincense_plate_id >", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdGreaterThanOrEqualTo(String value) {
            addCriterion("lincense_plate_id >=", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdLessThan(String value) {
            addCriterion("lincense_plate_id <", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdLessThanOrEqualTo(String value) {
            addCriterion("lincense_plate_id <=", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdLike(String value) {
            addCriterion("lincense_plate_id like", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdNotLike(String value) {
            addCriterion("lincense_plate_id not like", value, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdIn(List<String> values) {
            addCriterion("lincense_plate_id in", values, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdNotIn(List<String> values) {
            addCriterion("lincense_plate_id not in", values, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdBetween(String value1, String value2) {
            addCriterion("lincense_plate_id between", value1, value2, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andLincensePlateIdNotBetween(String value1, String value2) {
            addCriterion("lincense_plate_id not between", value1, value2, "lincensePlateId");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNull() {
            addCriterion("expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNotNull() {
            addCriterion("expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeEqualTo(Date value) {
            addCriterion("expiration_time =", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotEqualTo(Date value) {
            addCriterion("expiration_time <>", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThan(Date value) {
            addCriterion("expiration_time >", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_time >=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThan(Date value) {
            addCriterion("expiration_time <", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_time <=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIn(List<Date> values) {
            addCriterion("expiration_time in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotIn(List<Date> values) {
            addCriterion("expiration_time not in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_time between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_time not between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyName =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyName <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyName like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyName not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyName in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIsNull() {
            addCriterion("departmentName is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIsNotNull() {
            addCriterion("departmentName is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameEqualTo(String value) {
            addCriterion("departmentName =", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotEqualTo(String value) {
            addCriterion("departmentName <>", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameGreaterThan(String value) {
            addCriterion("departmentName >", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameGreaterThanOrEqualTo(String value) {
            addCriterion("departmentName >=", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLessThan(String value) {
            addCriterion("departmentName <", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLessThanOrEqualTo(String value) {
            addCriterion("departmentName <=", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLike(String value) {
            addCriterion("departmentName like", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotLike(String value) {
            addCriterion("departmentName not like", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIn(List<String> values) {
            addCriterion("departmentName in", values, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotIn(List<String> values) {
            addCriterion("departmentName not in", values, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameBetween(String value1, String value2) {
            addCriterion("departmentName between", value1, value2, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotBetween(String value1, String value2) {
            addCriterion("departmentName not between", value1, value2, "departmentname");
            return (Criteria) this;
        }

        public Criteria andMemberaddressIsNull() {
            addCriterion("memberAddress is null");
            return (Criteria) this;
        }

        public Criteria andMemberaddressIsNotNull() {
            addCriterion("memberAddress is not null");
            return (Criteria) this;
        }

        public Criteria andMemberaddressEqualTo(String value) {
            addCriterion("memberAddress =", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressNotEqualTo(String value) {
            addCriterion("memberAddress <>", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressGreaterThan(String value) {
            addCriterion("memberAddress >", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressGreaterThanOrEqualTo(String value) {
            addCriterion("memberAddress >=", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressLessThan(String value) {
            addCriterion("memberAddress <", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressLessThanOrEqualTo(String value) {
            addCriterion("memberAddress <=", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressLike(String value) {
            addCriterion("memberAddress like", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressNotLike(String value) {
            addCriterion("memberAddress not like", value, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressIn(List<String> values) {
            addCriterion("memberAddress in", values, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressNotIn(List<String> values) {
            addCriterion("memberAddress not in", values, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressBetween(String value1, String value2) {
            addCriterion("memberAddress between", value1, value2, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andMemberaddressNotBetween(String value1, String value2) {
            addCriterion("memberAddress not between", value1, value2, "memberaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIsNull() {
            addCriterion("companyAddress is null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIsNotNull() {
            addCriterion("companyAddress is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressEqualTo(String value) {
            addCriterion("companyAddress =", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotEqualTo(String value) {
            addCriterion("companyAddress <>", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressGreaterThan(String value) {
            addCriterion("companyAddress >", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressGreaterThanOrEqualTo(String value) {
            addCriterion("companyAddress >=", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLessThan(String value) {
            addCriterion("companyAddress <", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLessThanOrEqualTo(String value) {
            addCriterion("companyAddress <=", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLike(String value) {
            addCriterion("companyAddress like", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotLike(String value) {
            addCriterion("companyAddress not like", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIn(List<String> values) {
            addCriterion("companyAddress in", values, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotIn(List<String> values) {
            addCriterion("companyAddress not in", values, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressBetween(String value1, String value2) {
            addCriterion("companyAddress between", value1, value2, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotBetween(String value1, String value2) {
            addCriterion("companyAddress not between", value1, value2, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCarnameIsNull() {
            addCriterion("carName is null");
            return (Criteria) this;
        }

        public Criteria andCarnameIsNotNull() {
            addCriterion("carName is not null");
            return (Criteria) this;
        }

        public Criteria andCarnameEqualTo(String value) {
            addCriterion("carName =", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameNotEqualTo(String value) {
            addCriterion("carName <>", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameGreaterThan(String value) {
            addCriterion("carName >", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameGreaterThanOrEqualTo(String value) {
            addCriterion("carName >=", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameLessThan(String value) {
            addCriterion("carName <", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameLessThanOrEqualTo(String value) {
            addCriterion("carName <=", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameLike(String value) {
            addCriterion("carName like", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameNotLike(String value) {
            addCriterion("carName not like", value, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameIn(List<String> values) {
            addCriterion("carName in", values, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameNotIn(List<String> values) {
            addCriterion("carName not in", values, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameBetween(String value1, String value2) {
            addCriterion("carName between", value1, value2, "carname");
            return (Criteria) this;
        }

        public Criteria andCarnameNotBetween(String value1, String value2) {
            addCriterion("carName not between", value1, value2, "carname");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyIsNull() {
            addCriterion("stored_money is null");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyIsNotNull() {
            addCriterion("stored_money is not null");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyEqualTo(String value) {
            addCriterion("stored_money =", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyNotEqualTo(String value) {
            addCriterion("stored_money <>", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyGreaterThan(String value) {
            addCriterion("stored_money >", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("stored_money >=", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyLessThan(String value) {
            addCriterion("stored_money <", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyLessThanOrEqualTo(String value) {
            addCriterion("stored_money <=", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyLike(String value) {
            addCriterion("stored_money like", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyNotLike(String value) {
            addCriterion("stored_money not like", value, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyIn(List<String> values) {
            addCriterion("stored_money in", values, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyNotIn(List<String> values) {
            addCriterion("stored_money not in", values, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyBetween(String value1, String value2) {
            addCriterion("stored_money between", value1, value2, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andStoredMoneyNotBetween(String value1, String value2) {
            addCriterion("stored_money not between", value1, value2, "storedMoney");
            return (Criteria) this;
        }

        public Criteria andCarcolorIsNull() {
            addCriterion("carColor is null");
            return (Criteria) this;
        }

        public Criteria andCarcolorIsNotNull() {
            addCriterion("carColor is not null");
            return (Criteria) this;
        }

        public Criteria andCarcolorEqualTo(String value) {
            addCriterion("carColor =", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotEqualTo(String value) {
            addCriterion("carColor <>", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorGreaterThan(String value) {
            addCriterion("carColor >", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorGreaterThanOrEqualTo(String value) {
            addCriterion("carColor >=", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLessThan(String value) {
            addCriterion("carColor <", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLessThanOrEqualTo(String value) {
            addCriterion("carColor <=", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLike(String value) {
            addCriterion("carColor like", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotLike(String value) {
            addCriterion("carColor not like", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorIn(List<String> values) {
            addCriterion("carColor in", values, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotIn(List<String> values) {
            addCriterion("carColor not in", values, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorBetween(String value1, String value2) {
            addCriterion("carColor between", value1, value2, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotBetween(String value1, String value2) {
            addCriterion("carColor not between", value1, value2, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNull() {
            addCriterion("carType is null");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNotNull() {
            addCriterion("carType is not null");
            return (Criteria) this;
        }

        public Criteria andCartypeEqualTo(String value) {
            addCriterion("carType =", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotEqualTo(String value) {
            addCriterion("carType <>", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThan(String value) {
            addCriterion("carType >", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThanOrEqualTo(String value) {
            addCriterion("carType >=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThan(String value) {
            addCriterion("carType <", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThanOrEqualTo(String value) {
            addCriterion("carType <=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLike(String value) {
            addCriterion("carType like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotLike(String value) {
            addCriterion("carType not like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeIn(List<String> values) {
            addCriterion("carType in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotIn(List<String> values) {
            addCriterion("carType not in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeBetween(String value1, String value2) {
            addCriterion("carType between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotBetween(String value1, String value2) {
            addCriterion("carType not between", value1, value2, "cartype");
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

        public Criteria andEnterUserIsNull() {
            addCriterion("enter_user is null");
            return (Criteria) this;
        }

        public Criteria andEnterUserIsNotNull() {
            addCriterion("enter_user is not null");
            return (Criteria) this;
        }

        public Criteria andEnterUserEqualTo(String value) {
            addCriterion("enter_user =", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserNotEqualTo(String value) {
            addCriterion("enter_user <>", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserGreaterThan(String value) {
            addCriterion("enter_user >", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserGreaterThanOrEqualTo(String value) {
            addCriterion("enter_user >=", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserLessThan(String value) {
            addCriterion("enter_user <", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserLessThanOrEqualTo(String value) {
            addCriterion("enter_user <=", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserLike(String value) {
            addCriterion("enter_user like", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserNotLike(String value) {
            addCriterion("enter_user not like", value, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserIn(List<String> values) {
            addCriterion("enter_user in", values, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserNotIn(List<String> values) {
            addCriterion("enter_user not in", values, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserBetween(String value1, String value2) {
            addCriterion("enter_user between", value1, value2, "enterUser");
            return (Criteria) this;
        }

        public Criteria andEnterUserNotBetween(String value1, String value2) {
            addCriterion("enter_user not between", value1, value2, "enterUser");
            return (Criteria) this;
        }

        public Criteria andLgIdIsNull() {
            addCriterion("lg_id is null");
            return (Criteria) this;
        }

        public Criteria andLgIdIsNotNull() {
            addCriterion("lg_id is not null");
            return (Criteria) this;
        }

        public Criteria andLgIdEqualTo(Integer value) {
            addCriterion("lg_id =", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotEqualTo(Integer value) {
            addCriterion("lg_id <>", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdGreaterThan(Integer value) {
            addCriterion("lg_id >", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lg_id >=", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdLessThan(Integer value) {
            addCriterion("lg_id <", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdLessThanOrEqualTo(Integer value) {
            addCriterion("lg_id <=", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdIn(List<Integer> values) {
            addCriterion("lg_id in", values, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotIn(List<Integer> values) {
            addCriterion("lg_id not in", values, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdBetween(Integer value1, Integer value2) {
            addCriterion("lg_id between", value1, value2, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lg_id not between", value1, value2, "lgId");
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