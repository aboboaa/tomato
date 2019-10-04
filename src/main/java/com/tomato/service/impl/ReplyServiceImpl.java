package com.tomato.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomato.entitys.Reply;
import com.tomato.entitys.User;
import com.tomato.mapper.ReplyMapper;
import com.tomato.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public PageInfo<Reply> listReply(int post_id,int pageNo, int pageSize) {

        PageHelper.startPage(pageNo,pageSize);
        List<Reply> reply = replyMapper.findAllReplyByPost_id(post_id);
        PageInfo<Reply> page = new PageInfo<Reply>(reply);
        return page;
    }

    @Override
    public int addReply(String r_content, int post_id, int user_id) {

        Reply reply = new Reply();

        User user = new User();

        user.setUser_id(user_id);

        reply.setR_content(r_content);

        reply.setPost_id(post_id);

        reply.setUser(user);

        reply.setTime(new Date());


        return replyMapper.insertReply(reply);


    }


}
