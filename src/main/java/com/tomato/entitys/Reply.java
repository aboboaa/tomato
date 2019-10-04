package com.tomato.entitys;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {

    private Integer reply_id;

    private String r_content;

    private User user;

    private Date time;

    private Integer post_id;

    private Integer p_click_count;

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
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

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getP_click_count() {
        return p_click_count;
    }

    public void setP_click_count(Integer p_click_count) {
        this.p_click_count = p_click_count;
    }
}
