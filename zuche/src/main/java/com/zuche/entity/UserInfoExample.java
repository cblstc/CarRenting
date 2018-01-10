package com.zuche.entity;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoIsNull() {
            addCriterion("idcardPhoto is null");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoIsNotNull() {
            addCriterion("idcardPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoEqualTo(String value) {
            addCriterion("idcardPhoto =", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoNotEqualTo(String value) {
            addCriterion("idcardPhoto <>", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoGreaterThan(String value) {
            addCriterion("idcardPhoto >", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoGreaterThanOrEqualTo(String value) {
            addCriterion("idcardPhoto >=", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoLessThan(String value) {
            addCriterion("idcardPhoto <", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoLessThanOrEqualTo(String value) {
            addCriterion("idcardPhoto <=", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoLike(String value) {
            addCriterion("idcardPhoto like", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoNotLike(String value) {
            addCriterion("idcardPhoto not like", value, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoIn(List<String> values) {
            addCriterion("idcardPhoto in", values, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoNotIn(List<String> values) {
            addCriterion("idcardPhoto not in", values, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoBetween(String value1, String value2) {
            addCriterion("idcardPhoto between", value1, value2, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andIdcardphotoNotBetween(String value1, String value2) {
            addCriterion("idcardPhoto not between", value1, value2, "idcardphoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoIsNull() {
            addCriterion("licencePhoto is null");
            return (Criteria) this;
        }

        public Criteria andLicencephotoIsNotNull() {
            addCriterion("licencePhoto is not null");
            return (Criteria) this;
        }

        public Criteria andLicencephotoEqualTo(String value) {
            addCriterion("licencePhoto =", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoNotEqualTo(String value) {
            addCriterion("licencePhoto <>", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoGreaterThan(String value) {
            addCriterion("licencePhoto >", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoGreaterThanOrEqualTo(String value) {
            addCriterion("licencePhoto >=", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoLessThan(String value) {
            addCriterion("licencePhoto <", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoLessThanOrEqualTo(String value) {
            addCriterion("licencePhoto <=", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoLike(String value) {
            addCriterion("licencePhoto like", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoNotLike(String value) {
            addCriterion("licencePhoto not like", value, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoIn(List<String> values) {
            addCriterion("licencePhoto in", values, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoNotIn(List<String> values) {
            addCriterion("licencePhoto not in", values, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoBetween(String value1, String value2) {
            addCriterion("licencePhoto between", value1, value2, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencephotoNotBetween(String value1, String value2) {
            addCriterion("licencePhoto not between", value1, value2, "licencephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoIsNull() {
            addCriterion("licenceVicePhoto is null");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoIsNotNull() {
            addCriterion("licenceVicePhoto is not null");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoEqualTo(String value) {
            addCriterion("licenceVicePhoto =", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoNotEqualTo(String value) {
            addCriterion("licenceVicePhoto <>", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoGreaterThan(String value) {
            addCriterion("licenceVicePhoto >", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoGreaterThanOrEqualTo(String value) {
            addCriterion("licenceVicePhoto >=", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoLessThan(String value) {
            addCriterion("licenceVicePhoto <", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoLessThanOrEqualTo(String value) {
            addCriterion("licenceVicePhoto <=", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoLike(String value) {
            addCriterion("licenceVicePhoto like", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoNotLike(String value) {
            addCriterion("licenceVicePhoto not like", value, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoIn(List<String> values) {
            addCriterion("licenceVicePhoto in", values, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoNotIn(List<String> values) {
            addCriterion("licenceVicePhoto not in", values, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoBetween(String value1, String value2) {
            addCriterion("licenceVicePhoto between", value1, value2, "licencevicephoto");
            return (Criteria) this;
        }

        public Criteria andLicencevicephotoNotBetween(String value1, String value2) {
            addCriterion("licenceVicePhoto not between", value1, value2, "licencevicephoto");
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