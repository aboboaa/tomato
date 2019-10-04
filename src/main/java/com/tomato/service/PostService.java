package com.tomato.service;

import com.github.pagehelper.PageInfo;
import com.tomato.entitys.Post;

public interface PostService {

    //查询并分页帖子
    PageInfo<Post> listPost(int pageNo , int pageSize);

    //查询单个帖子
    Post findById(int post_id);

    //增加帖子
    int addPost(String title,String p_content,int user_id);

    //删除帖子
    int deletePost(int post_id);

    //修改帖子
    int updatePost(Post post);

    //通过关键字寻找标题
    PageInfo<Post> findByPostTitle(String title,int pageNo,int pageSize);

}
