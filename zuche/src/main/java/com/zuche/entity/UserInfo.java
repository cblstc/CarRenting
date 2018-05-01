package com.zuche.entity;

public class UserInfo {
    private Integer id;

    private Integer userId;

    private String name;

    private Integer sex;

    private String idcard;

    private String photo;

    private String idcardphoto;

    private String licencephoto;

    private String licencevicephoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getIdcardphoto() {
        return idcardphoto;
    }

    public void setIdcardphoto(String idcardphoto) {
        this.idcardphoto = idcardphoto == null ? null : idcardphoto.trim();
    }

    public String getLicencephoto() {
        return licencephoto;
    }

    public void setLicencephoto(String licencephoto) {
        this.licencephoto = licencephoto == null ? null : licencephoto.trim();
    }

    public String getLicencevicephoto() {
        return licencevicephoto;
    }

    public void setLicencevicephoto(String licencevicephoto) {
        this.licencevicephoto = licencevicephoto == null ? null : licencevicephoto.trim();
    }
}