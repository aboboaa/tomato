package com.tomato.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomato.entitys.Post;
import com.tomato.entitys.User;
import com.tomato.mapper.PostMapper;
import com.tomato.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceLmpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public PageInfo<Post> listPost(int pageNo, int pageSize) {

        PageHelper.startPage(pageNo,pageSize);
        List<Post> post = postMapper.listAllPost();
        PageInfo<Post> page = new PageInfo<Post>(post);
        return page;

    }

    @Override
    public Post findById(int post_id) {

        return postMapper.findpostById(post_id);
    }

    @Override
    public int addPost(String title,String p_content,int user_id) {

        Post post = new Post();

        User user = new User();

        user.setUser_id(user_id);

        post.setTitle(title);
        post.setP_content(p_content);
        post.setUser(user);
        post.setTime(new Date());
        post.setP_click_count(0);


        return postMapper.insertPost(post);
    }

    @Override
    public int deletePost(int post_id) {

        return postMapper.deletePostById(post_id);
    }

    @Override
    public int updatePost(Post post) {

        return postMapper.uodatePost(post);
    }

    @Override
    public PageInfo<Post> findByPostTitle(String title,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Post> post = postMapper.findByPostTitle(title);
        PageInfo<Post> page = new PageInfo<Post>(post);
        return page;
    }


}
