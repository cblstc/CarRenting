package com.zuche.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCarExample implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6425591503040902901L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCarExample() {
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

        public Criteria andPlatenumberIsNull() {
            addCriterion("plateNumber is null");
            return (Criteria) this;
        }

        public Criteria andPlatenumberIsNotNull() {
            addCriterion("plateNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPlatenumberEqualTo(String value) {
            addCriterion("plateNumber =", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberNotEqualTo(String value) {
            addCriterion("plateNumber <>", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberGreaterThan(String value) {
            addCriterion("plateNumber >", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberGreaterThanOrEqualTo(String value) {
            addCriterion("plateNumber >=", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberLessThan(String value) {
            addCriterion("plateNumber <", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberLessThanOrEqualTo(String value) {
            addCriterion("plateNumber <=", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberLike(String value) {
            addCriterion("plateNumber like", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberNotLike(String value) {
            addCriterion("plateNumber not like", value, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberIn(List<String> values) {
            addCriterion("plateNumber in", values, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberNotIn(List<String> values) {
            addCriterion("plateNumber not in", values, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberBetween(String value1, String value2) {
            addCriterion("plateNumber between", value1, value2, "platenumber");
            return (Criteria) this;
        }

        public Criteria andPlatenumberNotBetween(String value1, String value2) {
            addCriterion("plateNumber not between", value1, value2, "platenumber");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andConfigurationIsNull() {
            addCriterion("configuration is null");
            return (Criteria) this;
        }

        public Criteria andConfigurationIsNotNull() {
            addCriterion("configuration is not null");
            return (Criteria) this;
        }

        public Criteria andConfigurationEqualTo(String value) {
            addCriterion("configuration =", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationNotEqualTo(String value) {
            addCriterion("configuration <>", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationGreaterThan(String value) {
            addCriterion("configuration >", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationGreaterThanOrEqualTo(String value) {
            addCriterion("configuration >=", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationLessThan(String value) {
            addCriterion("configuration <", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationLessThanOrEqualTo(String value) {
            addCriterion("configuration <=", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationLike(String value) {
            addCriterion("configuration like", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationNotLike(String value) {
            addCriterion("configuration not like", value, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationIn(List<String> values) {
            addCriterion("configuration in", values, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationNotIn(List<String> values) {
            addCriterion("configuration not in", values, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationBetween(String value1, String value2) {
            addCriterion("configuration between", value1, value2, "configuration");
            return (Criteria) this;
        }

        public Criteria andConfigurationNotBetween(String value1, String value2) {
            addCriterion("configuration not between", value1, value2, "configuration");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNull() {
            addCriterion("gearbox is null");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNotNull() {
            addCriterion("gearbox is not null");
            return (Criteria) this;
        }

        public Criteria andGearboxEqualTo(Integer value) {
            addCriterion("gearbox =", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotEqualTo(Integer value) {
            addCriterion("gearbox <>", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThan(Integer value) {
            addCriterion("gearbox >", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThanOrEqualTo(Integer value) {
            addCriterion("gearbox >=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThan(Integer value) {
            addCriterion("gearbox <", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThanOrEqualTo(Integer value) {
            addCriterion("gearbox <=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxIn(List<Integer> values) {
            addCriterion("gearbox in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotIn(List<Integer> values) {
            addCriterion("gearbox not in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxBetween(Integer value1, Integer value2) {
            addCriterion("gearbox between", value1, value2, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotBetween(Integer value1, Integer value2) {
            addCriterion("gearbox not between", value1, value2, "gearbox");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNull() {
            addCriterion("displacement is null");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNotNull() {
            addCriterion("displacement is not null");
            return (Criteria) this;
        }

        public Criteria andDisplacementEqualTo(String value) {
            addCriterion("displacement =", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotEqualTo(String value) {
            addCriterion("displacement <>", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThan(String value) {
            addCriterion("displacement >", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThanOrEqualTo(String value) {
            addCriterion("displacement >=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThan(String value) {
            addCriterion("displacement <", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThanOrEqualTo(String value) {
            addCriterion("displacement <=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLike(String value) {
            addCriterion("displacement like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotLike(String value) {
            addCriterion("displacement not like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementIn(List<String> values) {
            addCriterion("displacement in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotIn(List<String> values) {
            addCriterion("displacement not in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementBetween(String value1, String value2) {
            addCriterion("displacement between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotBetween(String value1, String value2) {
            addCriterion("displacement not between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andNavigatorIsNull() {
            addCriterion("navigator is null");
            return (Criteria) this;
        }

        public Criteria andNavigatorIsNotNull() {
            addCriterion("navigator is not null");
            return (Criteria) this;
        }

        public Criteria andNavigatorEqualTo(Integer value) {
            addCriterion("navigator =", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorNotEqualTo(Integer value) {
            addCriterion("navigator <>", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorGreaterThan(Integer value) {
            addCriterion("navigator >", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("navigator >=", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorLessThan(Integer value) {
            addCriterion("navigator <", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorLessThanOrEqualTo(Integer value) {
            addCriterion("navigator <=", value, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorIn(List<Integer> values) {
            addCriterion("navigator in", values, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorNotIn(List<Integer> values) {
            addCriterion("navigator not in", values, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorBetween(Integer value1, Integer value2) {
            addCriterion("navigator between", value1, value2, "navigator");
            return (Criteria) this;
        }

        public Criteria andNavigatorNotBetween(Integer value1, Integer value2) {
            addCriterion("navigator not between", value1, value2, "navigator");
            return (Criteria) this;
        }

        public Criteria andPdcIsNull() {
            addCriterion("pdc is null");
            return (Criteria) this;
        }

        public Criteria andPdcIsNotNull() {
            addCriterion("pdc is not null");
            return (Criteria) this;
        }

        public Criteria andPdcEqualTo(Integer value) {
            addCriterion("pdc =", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcNotEqualTo(Integer value) {
            addCriterion("pdc <>", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcGreaterThan(Integer value) {
            addCriterion("pdc >", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcGreaterThanOrEqualTo(Integer value) {
            addCriterion("pdc >=", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcLessThan(Integer value) {
            addCriterion("pdc <", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcLessThanOrEqualTo(Integer value) {
            addCriterion("pdc <=", value, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcIn(List<Integer> values) {
            addCriterion("pdc in", values, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcNotIn(List<Integer> values) {
            addCriterion("pdc not in", values, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcBetween(Integer value1, Integer value2) {
            addCriterion("pdc between", value1, value2, "pdc");
            return (Criteria) this;
        }

        public Criteria andPdcNotBetween(Integer value1, Integer value2) {
            addCriterion("pdc not between", value1, value2, "pdc");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeIsNull() {
            addCriterion("drivenMode is null");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeIsNotNull() {
            addCriterion("drivenMode is not null");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeEqualTo(Integer value) {
            addCriterion("drivenMode =", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeNotEqualTo(Integer value) {
            addCriterion("drivenMode <>", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeGreaterThan(Integer value) {
            addCriterion("drivenMode >", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("drivenMode >=", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeLessThan(Integer value) {
            addCriterion("drivenMode <", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeLessThanOrEqualTo(Integer value) {
            addCriterion("drivenMode <=", value, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeIn(List<Integer> values) {
            addCriterion("drivenMode in", values, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeNotIn(List<Integer> values) {
            addCriterion("drivenMode not in", values, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeBetween(Integer value1, Integer value2) {
            addCriterion("drivenMode between", value1, value2, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andDrivenmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("drivenMode not between", value1, value2, "drivenmode");
            return (Criteria) this;
        }

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(Integer value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(Integer value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(Integer value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(Integer value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(Integer value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(Integer value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<Integer> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<Integer> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(Integer value1, Integer value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(Integer value1, Integer value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andFueltankageIsNull() {
            addCriterion("fuelTankage is null");
            return (Criteria) this;
        }

        public Criteria andFueltankageIsNotNull() {
            addCriterion("fuelTankage is not null");
            return (Criteria) this;
        }

        public Criteria andFueltankageEqualTo(Integer value) {
            addCriterion("fuelTankage =", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageNotEqualTo(Integer value) {
            addCriterion("fuelTankage <>", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageGreaterThan(Integer value) {
            addCriterion("fuelTankage >", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuelTankage >=", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageLessThan(Integer value) {
            addCriterion("fuelTankage <", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageLessThanOrEqualTo(Integer value) {
            addCriterion("fuelTankage <=", value, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageIn(List<Integer> values) {
            addCriterion("fuelTankage in", values, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageNotIn(List<Integer> values) {
            addCriterion("fuelTankage not in", values, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageBetween(Integer value1, Integer value2) {
            addCriterion("fuelTankage between", value1, value2, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andFueltankageNotBetween(Integer value1, Integer value2) {
            addCriterion("fuelTankage not between", value1, value2, "fueltankage");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDispositIsNull() {
            addCriterion("disposit is null");
            return (Criteria) this;
        }

        public Criteria andDispositIsNotNull() {
            addCriterion("disposit is not null");
            return (Criteria) this;
        }

        public Criteria andDispositEqualTo(Float value) {
            addCriterion("disposit =", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositNotEqualTo(Float value) {
            addCriterion("disposit <>", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositGreaterThan(Float value) {
            addCriterion("disposit >", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositGreaterThanOrEqualTo(Float value) {
            addCriterion("disposit >=", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositLessThan(Float value) {
            addCriterion("disposit <", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositLessThanOrEqualTo(Float value) {
            addCriterion("disposit <=", value, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositIn(List<Float> values) {
            addCriterion("disposit in", values, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositNotIn(List<Float> values) {
            addCriterion("disposit not in", values, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositBetween(Float value1, Float value2) {
            addCriterion("disposit between", value1, value2, "disposit");
            return (Criteria) this;
        }

        public Criteria andDispositNotBetween(Float value1, Float value2) {
            addCriterion("disposit not between", value1, value2, "disposit");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountIsNull() {
            addCriterion("ordertakingCount is null");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountIsNotNull() {
            addCriterion("ordertakingCount is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountEqualTo(Integer value) {
            addCriterion("ordertakingCount =", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountNotEqualTo(Integer value) {
            addCriterion("ordertakingCount <>", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountGreaterThan(Integer value) {
            addCriterion("ordertakingCount >", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordertakingCount >=", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountLessThan(Integer value) {
            addCriterion("ordertakingCount <", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountLessThanOrEqualTo(Integer value) {
            addCriterion("ordertakingCount <=", value, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountIn(List<Integer> values) {
            addCriterion("ordertakingCount in", values, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountNotIn(List<Integer> values) {
            addCriterion("ordertakingCount not in", values, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountBetween(Integer value1, Integer value2) {
            addCriterion("ordertakingCount between", value1, value2, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andOrdertakingcountNotBetween(Integer value1, Integer value2) {
            addCriterion("ordertakingCount not between", value1, value2, "ordertakingcount");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Integer value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Integer value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Integer value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Integer value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Integer value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Integer> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Integer> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Integer value1, Integer value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateIsNull() {
            addCriterion("ordertakingRate is null");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateIsNotNull() {
            addCriterion("ordertakingRate is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateEqualTo(Float value) {
            addCriterion("ordertakingRate =", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateNotEqualTo(Float value) {
            addCriterion("ordertakingRate <>", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateGreaterThan(Float value) {
            addCriterion("ordertakingRate >", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateGreaterThanOrEqualTo(Float value) {
            addCriterion("ordertakingRate >=", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateLessThan(Float value) {
            addCriterion("ordertakingRate <", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateLessThanOrEqualTo(Float value) {
            addCriterion("ordertakingRate <=", value, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateIn(List<Float> values) {
            addCriterion("ordertakingRate in", values, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateNotIn(List<Float> values) {
            addCriterion("ordertakingRate not in", values, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateBetween(Float value1, Float value2) {
            addCriterion("ordertakingRate between", value1, value2, "ordertakingrate");
            return (Criteria) this;
        }

        public Criteria andOrdertakingrateNotBetween(Float value1, Float value2) {
            addCriterion("ordertakingRate not between", value1, value2, "ordertakingrate");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalstarIsNull() {
            addCriterion("totalStar is null");
            return (Criteria) this;
        }

        public Criteria andTotalstarIsNotNull() {
            addCriterion("totalStar is not null");
            return (Criteria) this;
        }

        public Criteria andTotalstarEqualTo(Integer value) {
            addCriterion("totalStar =", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarNotEqualTo(Integer value) {
            addCriterion("totalStar <>", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarGreaterThan(Integer value) {
            addCriterion("totalStar >", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalStar >=", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarLessThan(Integer value) {
            addCriterion("totalStar <", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarLessThanOrEqualTo(Integer value) {
            addCriterion("totalStar <=", value, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarIn(List<Integer> values) {
            addCriterion("totalStar in", values, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarNotIn(List<Integer> values) {
            addCriterion("totalStar not in", values, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarBetween(Integer value1, Integer value2) {
            addCriterion("totalStar between", value1, value2, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalstarNotBetween(Integer value1, Integer value2) {
            addCriterion("totalStar not between", value1, value2, "totalstar");
            return (Criteria) this;
        }

        public Criteria andTotalcommentIsNull() {
            addCriterion("totalComment is null");
            return (Criteria) this;
        }

        public Criteria andTotalcommentIsNotNull() {
            addCriterion("totalComment is not null");
            return (Criteria) this;
        }

        public Criteria andTotalcommentEqualTo(Integer value) {
            addCriterion("totalComment =", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentNotEqualTo(Integer value) {
            addCriterion("totalComment <>", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentGreaterThan(Integer value) {
            addCriterion("totalComment >", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalComment >=", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentLessThan(Integer value) {
            addCriterion("totalComment <", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentLessThanOrEqualTo(Integer value) {
            addCriterion("totalComment <=", value, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentIn(List<Integer> values) {
            addCriterion("totalComment in", values, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentNotIn(List<Integer> values) {
            addCriterion("totalComment not in", values, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentBetween(Integer value1, Integer value2) {
            addCriterion("totalComment between", value1, value2, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andTotalcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("totalComment not between", value1, value2, "totalcomment");
            return (Criteria) this;
        }

        public Criteria andAvgstarIsNull() {
            addCriterion("avgStar is null");
            return (Criteria) this;
        }

        public Criteria andAvgstarIsNotNull() {
            addCriterion("avgStar is not null");
            return (Criteria) this;
        }

        public Criteria andAvgstarEqualTo(Float value) {
            addCriterion("avgStar =", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarNotEqualTo(Float value) {
            addCriterion("avgStar <>", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarGreaterThan(Float value) {
            addCriterion("avgStar >", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarGreaterThanOrEqualTo(Float value) {
            addCriterion("avgStar >=", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarLessThan(Float value) {
            addCriterion("avgStar <", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarLessThanOrEqualTo(Float value) {
            addCriterion("avgStar <=", value, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarIn(List<Float> values) {
            addCriterion("avgStar in", values, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarNotIn(List<Float> values) {
            addCriterion("avgStar not in", values, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarBetween(Float value1, Float value2) {
            addCriterion("avgStar between", value1, value2, "avgstar");
            return (Criteria) this;
        }

        public Criteria andAvgstarNotBetween(Float value1, Float value2) {
            addCriterion("avgStar not between", value1, value2, "avgstar");
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