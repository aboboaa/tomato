package com.tomato.mapper;

import com.tomato.entitys.Post;
import com.tomato.provider.PostProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PostMapper {

    //查找所有帖子
    @Select("select post_id,title,user_id,time,p_click_count from post ORDER BY post_id DESC")
    @Results({
            @Result(property="user",column="user_id",one=@One(select="com.tomato.mapper.UserMapper.findByUserId"))
    })
    List<Post> listAllPost();

    //通过id查找帖子
    @Select("select post_id,title,p_content,user_id,time,p_click_count from post where post_id=#{post_id}")
    @Results({
            @Result(property="user",column="user_id",one=@One(select="com.tomato.mapper.UserMapper.findByUserId"))
    })
    Post findpostById(int post_id);

    //通过id删除帖子
    @Delete("delete from post where post_id=#{post_id}")
    int deletePostById(int post_id);

    //添加帖子
    @InsertProvider(type = PostProvider.class ,method ="insertPost")
    int insertPost(Post post);

    //修改帖子
    @UpdateProvider(type = PostProvider.class ,method = "updatePost")
    int uodatePost(Post post);

    //通过关键字查询标题
    @Select("select * from post where title  like '%${title}%'")
    List<Post> findByPostTitle (String title);

}
