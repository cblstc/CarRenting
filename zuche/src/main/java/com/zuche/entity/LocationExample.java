package com.zuche.entity;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LocationExample() {
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

        public Criteria andOrdersIdIsNull() {
            addCriterion("orders_id is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIsNotNull() {
            addCriterion("orders_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdEqualTo(String value) {
            addCriterion("orders_id =", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotEqualTo(String value) {
            addCriterion("orders_id <>", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThan(String value) {
            addCriterion("orders_id >", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThanOrEqualTo(String value) {
            addCriterion("orders_id >=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThan(String value) {
            addCriterion("orders_id <", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThanOrEqualTo(String value) {
            addCriterion("orders_id <=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLike(String value) {
            addCriterion("orders_id like", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotLike(String value) {
            addCriterion("orders_id not like", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIn(List<String> values) {
            addCriterion("orders_id in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotIn(List<String> values) {
            addCriterion("orders_id not in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdBetween(String value1, String value2) {
            addCriterion("orders_id between", value1, value2, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotBetween(String value1, String value2) {
            addCriterion("orders_id not between", value1, value2, "ordersId");
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

        public Criteria andGetaddressIsNull() {
            addCriterion("getAddress is null");
            return (Criteria) this;
        }

        public Criteria andGetaddressIsNotNull() {
            addCriterion("getAddress is not null");
            return (Criteria) this;
        }

        public Criteria andGetaddressEqualTo(String value) {
            addCriterion("getAddress =", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressNotEqualTo(String value) {
            addCriterion("getAddress <>", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressGreaterThan(String value) {
            addCriterion("getAddress >", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressGreaterThanOrEqualTo(String value) {
            addCriterion("getAddress >=", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressLessThan(String value) {
            addCriterion("getAddress <", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressLessThanOrEqualTo(String value) {
            addCriterion("getAddress <=", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressLike(String value) {
            addCriterion("getAddress like", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressNotLike(String value) {
            addCriterion("getAddress not like", value, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressIn(List<String> values) {
            addCriterion("getAddress in", values, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressNotIn(List<String> values) {
            addCriterion("getAddress not in", values, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressBetween(String value1, String value2) {
            addCriterion("getAddress between", value1, value2, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetaddressNotBetween(String value1, String value2) {
            addCriterion("getAddress not between", value1, value2, "getaddress");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeIsNull() {
            addCriterion("getLongitude is null");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeIsNotNull() {
            addCriterion("getLongitude is not null");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeEqualTo(Float value) {
            addCriterion("getLongitude =", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeNotEqualTo(Float value) {
            addCriterion("getLongitude <>", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeGreaterThan(Float value) {
            addCriterion("getLongitude >", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("getLongitude >=", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeLessThan(Float value) {
            addCriterion("getLongitude <", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeLessThanOrEqualTo(Float value) {
            addCriterion("getLongitude <=", value, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeIn(List<Float> values) {
            addCriterion("getLongitude in", values, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeNotIn(List<Float> values) {
            addCriterion("getLongitude not in", values, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeBetween(Float value1, Float value2) {
            addCriterion("getLongitude between", value1, value2, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlongitudeNotBetween(Float value1, Float value2) {
            addCriterion("getLongitude not between", value1, value2, "getlongitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeIsNull() {
            addCriterion("getLatitude is null");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeIsNotNull() {
            addCriterion("getLatitude is not null");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeEqualTo(Float value) {
            addCriterion("getLatitude =", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeNotEqualTo(Float value) {
            addCriterion("getLatitude <>", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeGreaterThan(Float value) {
            addCriterion("getLatitude >", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("getLatitude >=", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeLessThan(Float value) {
            addCriterion("getLatitude <", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeLessThanOrEqualTo(Float value) {
            addCriterion("getLatitude <=", value, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeIn(List<Float> values) {
            addCriterion("getLatitude in", values, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeNotIn(List<Float> values) {
            addCriterion("getLatitude not in", values, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeBetween(Float value1, Float value2) {
            addCriterion("getLatitude between", value1, value2, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andGetlatitudeNotBetween(Float value1, Float value2) {
            addCriterion("getLatitude not between", value1, value2, "getlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnaddressIsNull() {
            addCriterion("returnAddress is null");
            return (Criteria) this;
        }

        public Criteria andReturnaddressIsNotNull() {
            addCriterion("returnAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReturnaddressEqualTo(String value) {
            addCriterion("returnAddress =", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressNotEqualTo(String value) {
            addCriterion("returnAddress <>", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressGreaterThan(String value) {
            addCriterion("returnAddress >", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressGreaterThanOrEqualTo(String value) {
            addCriterion("returnAddress >=", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressLessThan(String value) {
            addCriterion("returnAddress <", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressLessThanOrEqualTo(String value) {
            addCriterion("returnAddress <=", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressLike(String value) {
            addCriterion("returnAddress like", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressNotLike(String value) {
            addCriterion("returnAddress not like", value, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressIn(List<String> values) {
            addCriterion("returnAddress in", values, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressNotIn(List<String> values) {
            addCriterion("returnAddress not in", values, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressBetween(String value1, String value2) {
            addCriterion("returnAddress between", value1, value2, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnaddressNotBetween(String value1, String value2) {
            addCriterion("returnAddress not between", value1, value2, "returnaddress");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeIsNull() {
            addCriterion("returnLongitude is null");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeIsNotNull() {
            addCriterion("returnLongitude is not null");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeEqualTo(Float value) {
            addCriterion("returnLongitude =", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeNotEqualTo(Float value) {
            addCriterion("returnLongitude <>", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeGreaterThan(Float value) {
            addCriterion("returnLongitude >", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("returnLongitude >=", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeLessThan(Float value) {
            addCriterion("returnLongitude <", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeLessThanOrEqualTo(Float value) {
            addCriterion("returnLongitude <=", value, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeIn(List<Float> values) {
            addCriterion("returnLongitude in", values, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeNotIn(List<Float> values) {
            addCriterion("returnLongitude not in", values, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeBetween(Float value1, Float value2) {
            addCriterion("returnLongitude between", value1, value2, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlongitudeNotBetween(Float value1, Float value2) {
            addCriterion("returnLongitude not between", value1, value2, "returnlongitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeIsNull() {
            addCriterion("returnLatitude is null");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeIsNotNull() {
            addCriterion("returnLatitude is not null");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeEqualTo(Float value) {
            addCriterion("returnLatitude =", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeNotEqualTo(Float value) {
            addCriterion("returnLatitude <>", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeGreaterThan(Float value) {
            addCriterion("returnLatitude >", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("returnLatitude >=", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeLessThan(Float value) {
            addCriterion("returnLatitude <", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeLessThanOrEqualTo(Float value) {
            addCriterion("returnLatitude <=", value, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeIn(List<Float> values) {
            addCriterion("returnLatitude in", values, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeNotIn(List<Float> values) {
            addCriterion("returnLatitude not in", values, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeBetween(Float value1, Float value2) {
            addCriterion("returnLatitude between", value1, value2, "returnlatitude");
            return (Criteria) this;
        }

        public Criteria andReturnlatitudeNotBetween(Float value1, Float value2) {
            addCriterion("returnLatitude not between", value1, value2, "returnlatitude");
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