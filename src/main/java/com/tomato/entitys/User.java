package com.tomato.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_paswd")
    private String user_paswd;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "user_pho")
    private String user_pho;

    @Column(name = "user_sex")
    private Integer user_sex;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_brid")
    private Date user_brid;

    @Column(name = "user_adr")
    private String user_adr;

    @Column(name = "captcha")
    private String captcha;

    @Column(name = "attr1")
    private String attr1;

    private String img;



    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_paswd() {
        return user_paswd;
    }

    public void setUser_paswd(String user_paswd) {
        this.user_paswd = user_paswd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pho() {
        return user_pho;
    }

    public void setUser_pho(String user_pho) {
        this.user_pho = user_pho;
    }

    public Integer getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    public Date getUser_brid() {
        return user_brid;
    }

    public void setUser_brid(Date user_brid) {
        this.user_brid = user_brid;
    }

    public String getUser_adr() {
        return user_adr;
    }

    public void setUser_adr(String user_adr) {
        this.user_adr = user_adr;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
