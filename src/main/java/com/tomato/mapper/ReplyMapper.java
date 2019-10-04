package com.tomato.mapper;

import com.tomato.entitys.Reply;
import com.tomato.provider.ReplyProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReplyMapper {

    //通过post_id查找所有回复
    @Select("select * from reply where post_id = #{post_id} ORDER BY reply_id DESC")
    //使用@Results,通过user_id获取到user
    @Results({
            @Result(property="user",column="user_id",one=@One(select="com.tomato.mapper.UserMapper.findByUserId"))
    })
    List<Reply> findAllReplyByPost_id(int post_id);

    //插入回复
    @InsertProvider(type = ReplyProvider.class , method = "insertReply")
    int insertReply(Reply reply);

}
