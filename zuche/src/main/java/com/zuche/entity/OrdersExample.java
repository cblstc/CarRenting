package com.zuche.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdIsNull() {
            addCriterion("store_car_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdIsNotNull() {
            addCriterion("store_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdEqualTo(Integer value) {
            addCriterion("store_car_id =", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdNotEqualTo(Integer value) {
            addCriterion("store_car_id <>", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdGreaterThan(Integer value) {
            addCriterion("store_car_id >", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_car_id >=", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdLessThan(Integer value) {
            addCriterion("store_car_id <", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_car_id <=", value, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdIn(List<Integer> values) {
            addCriterion("store_car_id in", values, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdNotIn(List<Integer> values) {
            addCriterion("store_car_id not in", values, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdBetween(Integer value1, Integer value2) {
            addCriterion("store_car_id between", value1, value2, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andStoreCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_car_id not between", value1, value2, "storeCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdIsNull() {
            addCriterion("user_car_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCarIdIsNotNull() {
            addCriterion("user_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCarIdEqualTo(Integer value) {
            addCriterion("user_car_id =", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdNotEqualTo(Integer value) {
            addCriterion("user_car_id <>", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdGreaterThan(Integer value) {
            addCriterion("user_car_id >", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_car_id >=", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdLessThan(Integer value) {
            addCriterion("user_car_id <", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_car_id <=", value, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdIn(List<Integer> values) {
            addCriterion("user_car_id in", values, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdNotIn(List<Integer> values) {
            addCriterion("user_car_id not in", values, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdBetween(Integer value1, Integer value2) {
            addCriterion("user_car_id between", value1, value2, "userCarId");
            return (Criteria) this;
        }

        public Criteria andUserCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_car_id not between", value1, value2, "userCarId");
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

        public Criteria andInsuranceIsNull() {
            addCriterion("insurance is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceIsNotNull() {
            addCriterion("insurance is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceEqualTo(Float value) {
            addCriterion("insurance =", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotEqualTo(Float value) {
            addCriterion("insurance <>", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThan(Float value) {
            addCriterion("insurance >", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("insurance >=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThan(Float value) {
            addCriterion("insurance <", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThanOrEqualTo(Float value) {
            addCriterion("insurance <=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceIn(List<Float> values) {
            addCriterion("insurance in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotIn(List<Float> values) {
            addCriterion("insurance not in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceBetween(Float value1, Float value2) {
            addCriterion("insurance between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotBetween(Float value1, Float value2) {
            addCriterion("insurance not between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesIsNull() {
            addCriterion("nodeductibles is null");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesIsNotNull() {
            addCriterion("nodeductibles is not null");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesEqualTo(Float value) {
            addCriterion("nodeductibles =", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesNotEqualTo(Float value) {
            addCriterion("nodeductibles <>", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesGreaterThan(Float value) {
            addCriterion("nodeductibles >", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesGreaterThanOrEqualTo(Float value) {
            addCriterion("nodeductibles >=", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesLessThan(Float value) {
            addCriterion("nodeductibles <", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesLessThanOrEqualTo(Float value) {
            addCriterion("nodeductibles <=", value, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesIn(List<Float> values) {
            addCriterion("nodeductibles in", values, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesNotIn(List<Float> values) {
            addCriterion("nodeductibles not in", values, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesBetween(Float value1, Float value2) {
            addCriterion("nodeductibles between", value1, value2, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andNodeductiblesNotBetween(Float value1, Float value2) {
            addCriterion("nodeductibles not between", value1, value2, "nodeductibles");
            return (Criteria) this;
        }

        public Criteria andPoundageIsNull() {
            addCriterion("poundage is null");
            return (Criteria) this;
        }

        public Criteria andPoundageIsNotNull() {
            addCriterion("poundage is not null");
            return (Criteria) this;
        }

        public Criteria andPoundageEqualTo(Float value) {
            addCriterion("poundage =", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotEqualTo(Float value) {
            addCriterion("poundage <>", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThan(Float value) {
            addCriterion("poundage >", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThanOrEqualTo(Float value) {
            addCriterion("poundage >=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThan(Float value) {
            addCriterion("poundage <", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThanOrEqualTo(Float value) {
            addCriterion("poundage <=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageIn(List<Float> values) {
            addCriterion("poundage in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotIn(List<Float> values) {
            addCriterion("poundage not in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageBetween(Float value1, Float value2) {
            addCriterion("poundage between", value1, value2, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotBetween(Float value1, Float value2) {
            addCriterion("poundage not between", value1, value2, "poundage");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(Float value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(Float value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(Float value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(Float value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(Float value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<Float> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<Float> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(Float value1, Float value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(Float value1, Float value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
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

        public Criteria andGettimeIsNull() {
            addCriterion("getTime is null");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNotNull() {
            addCriterion("getTime is not null");
            return (Criteria) this;
        }

        public Criteria andGettimeEqualTo(Date value) {
            addCriterion("getTime =", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotEqualTo(Date value) {
            addCriterion("getTime <>", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThan(Date value) {
            addCriterion("getTime >", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("getTime >=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThan(Date value) {
            addCriterion("getTime <", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThanOrEqualTo(Date value) {
            addCriterion("getTime <=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeIn(List<Date> values) {
            addCriterion("getTime in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotIn(List<Date> values) {
            addCriterion("getTime not in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeBetween(Date value1, Date value2) {
            addCriterion("getTime between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotBetween(Date value1, Date value2) {
            addCriterion("getTime not between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNull() {
            addCriterion("returnTime is null");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNotNull() {
            addCriterion("returnTime is not null");
            return (Criteria) this;
        }

        public Criteria andReturntimeEqualTo(Date value) {
            addCriterion("returnTime =", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotEqualTo(Date value) {
            addCriterion("returnTime <>", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThan(Date value) {
            addCriterion("returnTime >", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("returnTime >=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThan(Date value) {
            addCriterion("returnTime <", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThanOrEqualTo(Date value) {
            addCriterion("returnTime <=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIn(List<Date> values) {
            addCriterion("returnTime in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotIn(List<Date> values) {
            addCriterion("returnTime not in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeBetween(Date value1, Date value2) {
            addCriterion("returnTime between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotBetween(Date value1, Date value2) {
            addCriterion("returnTime not between", value1, value2, "returntime");
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