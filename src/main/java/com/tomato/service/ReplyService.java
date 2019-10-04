package com.tomato.service;

import com.github.pagehelper.PageInfo;
import com.tomato.entitys.Reply;



public interface ReplyService {

    //列出评论并分页
    PageInfo<Reply> listReply(int post_id, int pageNo, int pageSize);

    //评论功能
    int addReply(String r_content,int post_id,int user_id);

}
