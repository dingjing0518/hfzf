package com.jinshipark.hfzf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JinshiParkSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JinshiParkSettingExample() {
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

        public Criteria andJpsIdIsNull() {
            addCriterion("jps_id is null");
            return (Criteria) this;
        }

        public Criteria andJpsIdIsNotNull() {
            addCriterion("jps_id is not null");
            return (Criteria) this;
        }

        public Criteria andJpsIdEqualTo(Integer value) {
            addCriterion("jps_id =", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdNotEqualTo(Integer value) {
            addCriterion("jps_id <>", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdGreaterThan(Integer value) {
            addCriterion("jps_id >", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_id >=", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdLessThan(Integer value) {
            addCriterion("jps_id <", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdLessThanOrEqualTo(Integer value) {
            addCriterion("jps_id <=", value, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdIn(List<Integer> values) {
            addCriterion("jps_id in", values, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdNotIn(List<Integer> values) {
            addCriterion("jps_id not in", values, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdBetween(Integer value1, Integer value2) {
            addCriterion("jps_id between", value1, value2, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_id not between", value1, value2, "jpsId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdIsNull() {
            addCriterion("jps_park_id is null");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdIsNotNull() {
            addCriterion("jps_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdEqualTo(Integer value) {
            addCriterion("jps_park_id =", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdNotEqualTo(Integer value) {
            addCriterion("jps_park_id <>", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdGreaterThan(Integer value) {
            addCriterion("jps_park_id >", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_park_id >=", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdLessThan(Integer value) {
            addCriterion("jps_park_id <", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdLessThanOrEqualTo(Integer value) {
            addCriterion("jps_park_id <=", value, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdIn(List<Integer> values) {
            addCriterion("jps_park_id in", values, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdNotIn(List<Integer> values) {
            addCriterion("jps_park_id not in", values, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdBetween(Integer value1, Integer value2) {
            addCriterion("jps_park_id between", value1, value2, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsParkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_park_id not between", value1, value2, "jpsParkId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdIsNull() {
            addCriterion("jps_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdIsNotNull() {
            addCriterion("jps_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdEqualTo(Integer value) {
            addCriterion("jps_agent_id =", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdNotEqualTo(Integer value) {
            addCriterion("jps_agent_id <>", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdGreaterThan(Integer value) {
            addCriterion("jps_agent_id >", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_agent_id >=", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdLessThan(Integer value) {
            addCriterion("jps_agent_id <", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("jps_agent_id <=", value, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdIn(List<Integer> values) {
            addCriterion("jps_agent_id in", values, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdNotIn(List<Integer> values) {
            addCriterion("jps_agent_id not in", values, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("jps_agent_id between", value1, value2, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_agent_id not between", value1, value2, "jpsAgentId");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeIsNull() {
            addCriterion("jps_free_time is null");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeIsNotNull() {
            addCriterion("jps_free_time is not null");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeEqualTo(Integer value) {
            addCriterion("jps_free_time =", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeNotEqualTo(Integer value) {
            addCriterion("jps_free_time <>", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeGreaterThan(Integer value) {
            addCriterion("jps_free_time >", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_free_time >=", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeLessThan(Integer value) {
            addCriterion("jps_free_time <", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_free_time <=", value, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeIn(List<Integer> values) {
            addCriterion("jps_free_time in", values, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeNotIn(List<Integer> values) {
            addCriterion("jps_free_time not in", values, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeBetween(Integer value1, Integer value2) {
            addCriterion("jps_free_time between", value1, value2, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFreeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_free_time not between", value1, value2, "jpsFreeTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeIsNull() {
            addCriterion("jps_first_time is null");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeIsNotNull() {
            addCriterion("jps_first_time is not null");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeEqualTo(Integer value) {
            addCriterion("jps_first_time =", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeNotEqualTo(Integer value) {
            addCriterion("jps_first_time <>", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeGreaterThan(Integer value) {
            addCriterion("jps_first_time >", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_first_time >=", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeLessThan(Integer value) {
            addCriterion("jps_first_time <", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_first_time <=", value, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeIn(List<Integer> values) {
            addCriterion("jps_first_time in", values, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeNotIn(List<Integer> values) {
            addCriterion("jps_first_time not in", values, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeBetween(Integer value1, Integer value2) {
            addCriterion("jps_first_time between", value1, value2, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_first_time not between", value1, value2, "jpsFirstTime");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeIsNull() {
            addCriterion("jps_first_charge is null");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeIsNotNull() {
            addCriterion("jps_first_charge is not null");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeEqualTo(Integer value) {
            addCriterion("jps_first_charge =", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeNotEqualTo(Integer value) {
            addCriterion("jps_first_charge <>", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeGreaterThan(Integer value) {
            addCriterion("jps_first_charge >", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_first_charge >=", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeLessThan(Integer value) {
            addCriterion("jps_first_charge <", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_first_charge <=", value, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeIn(List<Integer> values) {
            addCriterion("jps_first_charge in", values, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeNotIn(List<Integer> values) {
            addCriterion("jps_first_charge not in", values, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeBetween(Integer value1, Integer value2) {
            addCriterion("jps_first_charge between", value1, value2, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFirstChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_first_charge not between", value1, value2, "jpsFirstCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeIsNull() {
            addCriterion("jps_follow_time is null");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeIsNotNull() {
            addCriterion("jps_follow_time is not null");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeEqualTo(Integer value) {
            addCriterion("jps_follow_time =", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeNotEqualTo(Integer value) {
            addCriterion("jps_follow_time <>", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeGreaterThan(Integer value) {
            addCriterion("jps_follow_time >", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_follow_time >=", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeLessThan(Integer value) {
            addCriterion("jps_follow_time <", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_follow_time <=", value, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeIn(List<Integer> values) {
            addCriterion("jps_follow_time in", values, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeNotIn(List<Integer> values) {
            addCriterion("jps_follow_time not in", values, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeBetween(Integer value1, Integer value2) {
            addCriterion("jps_follow_time between", value1, value2, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_follow_time not between", value1, value2, "jpsFollowTime");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeIsNull() {
            addCriterion("jps_follow_charge is null");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeIsNotNull() {
            addCriterion("jps_follow_charge is not null");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeEqualTo(Integer value) {
            addCriterion("jps_follow_charge =", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeNotEqualTo(Integer value) {
            addCriterion("jps_follow_charge <>", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeGreaterThan(Integer value) {
            addCriterion("jps_follow_charge >", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_follow_charge >=", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeLessThan(Integer value) {
            addCriterion("jps_follow_charge <", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_follow_charge <=", value, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeIn(List<Integer> values) {
            addCriterion("jps_follow_charge in", values, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeNotIn(List<Integer> values) {
            addCriterion("jps_follow_charge not in", values, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeBetween(Integer value1, Integer value2) {
            addCriterion("jps_follow_charge between", value1, value2, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsFollowChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_follow_charge not between", value1, value2, "jpsFollowCharge");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitIsNull() {
            addCriterion("jps_allday_limit is null");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitIsNotNull() {
            addCriterion("jps_allday_limit is not null");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitEqualTo(Integer value) {
            addCriterion("jps_allday_limit =", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitNotEqualTo(Integer value) {
            addCriterion("jps_allday_limit <>", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitGreaterThan(Integer value) {
            addCriterion("jps_allday_limit >", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_allday_limit >=", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitLessThan(Integer value) {
            addCriterion("jps_allday_limit <", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitLessThanOrEqualTo(Integer value) {
            addCriterion("jps_allday_limit <=", value, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitIn(List<Integer> values) {
            addCriterion("jps_allday_limit in", values, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitNotIn(List<Integer> values) {
            addCriterion("jps_allday_limit not in", values, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitBetween(Integer value1, Integer value2) {
            addCriterion("jps_allday_limit between", value1, value2, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAlldayLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_allday_limit not between", value1, value2, "jpsAlldayLimit");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeIsNull() {
            addCriterion("jps_advance_charge_outtime is null");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeIsNotNull() {
            addCriterion("jps_advance_charge_outtime is not null");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeEqualTo(Integer value) {
            addCriterion("jps_advance_charge_outtime =", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeNotEqualTo(Integer value) {
            addCriterion("jps_advance_charge_outtime <>", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeGreaterThan(Integer value) {
            addCriterion("jps_advance_charge_outtime >", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_advance_charge_outtime >=", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeLessThan(Integer value) {
            addCriterion("jps_advance_charge_outtime <", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_advance_charge_outtime <=", value, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeIn(List<Integer> values) {
            addCriterion("jps_advance_charge_outtime in", values, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeNotIn(List<Integer> values) {
            addCriterion("jps_advance_charge_outtime not in", values, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeBetween(Integer value1, Integer value2) {
            addCriterion("jps_advance_charge_outtime between", value1, value2, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsAdvanceChargeOuttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_advance_charge_outtime not between", value1, value2, "jpsAdvanceChargeOuttime");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkIsNull() {
            addCriterion("jps_remark is null");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkIsNotNull() {
            addCriterion("jps_remark is not null");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkEqualTo(String value) {
            addCriterion("jps_remark =", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkNotEqualTo(String value) {
            addCriterion("jps_remark <>", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkGreaterThan(String value) {
            addCriterion("jps_remark >", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("jps_remark >=", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkLessThan(String value) {
            addCriterion("jps_remark <", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkLessThanOrEqualTo(String value) {
            addCriterion("jps_remark <=", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkLike(String value) {
            addCriterion("jps_remark like", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkNotLike(String value) {
            addCriterion("jps_remark not like", value, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkIn(List<String> values) {
            addCriterion("jps_remark in", values, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkNotIn(List<String> values) {
            addCriterion("jps_remark not in", values, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkBetween(String value1, String value2) {
            addCriterion("jps_remark between", value1, value2, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsRemarkNotBetween(String value1, String value2) {
            addCriterion("jps_remark not between", value1, value2, "jpsRemark");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeIsNull() {
            addCriterion("jps_createtime is null");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeIsNotNull() {
            addCriterion("jps_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeEqualTo(Date value) {
            addCriterion("jps_createtime =", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeNotEqualTo(Date value) {
            addCriterion("jps_createtime <>", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeGreaterThan(Date value) {
            addCriterion("jps_createtime >", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jps_createtime >=", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeLessThan(Date value) {
            addCriterion("jps_createtime <", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("jps_createtime <=", value, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeIn(List<Date> values) {
            addCriterion("jps_createtime in", values, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeNotIn(List<Date> values) {
            addCriterion("jps_createtime not in", values, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeBetween(Date value1, Date value2) {
            addCriterion("jps_createtime between", value1, value2, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("jps_createtime not between", value1, value2, "jpsCreatetime");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteIsNull() {
            addCriterion("jps_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteIsNotNull() {
            addCriterion("jps_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteEqualTo(Integer value) {
            addCriterion("jps_isdelete =", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteNotEqualTo(Integer value) {
            addCriterion("jps_isdelete <>", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteGreaterThan(Integer value) {
            addCriterion("jps_isdelete >", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_isdelete >=", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteLessThan(Integer value) {
            addCriterion("jps_isdelete <", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("jps_isdelete <=", value, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteIn(List<Integer> values) {
            addCriterion("jps_isdelete in", values, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteNotIn(List<Integer> values) {
            addCriterion("jps_isdelete not in", values, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("jps_isdelete between", value1, value2, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_isdelete not between", value1, value2, "jpsIsdelete");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeIsNull() {
            addCriterion("jps_car_type is null");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeIsNotNull() {
            addCriterion("jps_car_type is not null");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeEqualTo(Integer value) {
            addCriterion("jps_car_type =", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeNotEqualTo(Integer value) {
            addCriterion("jps_car_type <>", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeGreaterThan(Integer value) {
            addCriterion("jps_car_type >", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jps_car_type >=", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeLessThan(Integer value) {
            addCriterion("jps_car_type <", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeLessThanOrEqualTo(Integer value) {
            addCriterion("jps_car_type <=", value, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeIn(List<Integer> values) {
            addCriterion("jps_car_type in", values, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeNotIn(List<Integer> values) {
            addCriterion("jps_car_type not in", values, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeBetween(Integer value1, Integer value2) {
            addCriterion("jps_car_type between", value1, value2, "jpsCarType");
            return (Criteria) this;
        }

        public Criteria andJpsCarTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("jps_car_type not between", value1, value2, "jpsCarType");
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