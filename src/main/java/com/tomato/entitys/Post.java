package com.tomato.entitys;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Post  implements Serializable{

    private  Integer post_id;

    private String  title;

    private String p_content;

    private User user;

    private Date time;

    private Integer p_click_count;

    private Integer pl_id;

    private String attr1;

    private String attr2;

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public String getAttr1() {
        return attr1;
    }
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }
    public String getAttr2() {
        return attr2;
    }
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getP_click_count() {
        return p_click_count;
    }

    public void setP_click_count(Integer p_click_count) {
        this.p_click_count = p_click_count;
    }

    public Integer getPl_id() {
        return pl_id;
    }
    public void setPl_id(Integer pl_id) {
        this.pl_id = pl_id;
    }


}
