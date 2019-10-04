package com.tomato.service;

import com.tomato.entitys.User;

public interface UserService {

    //检查登录
    User checkLogin(String username, String password);

    //注册
    void regist(User user);
    boolean findByUserPhone(String user_pho);
    //手机查找用户
    User findByUserPh(String user_pho);
    //修改

    void UpdateUserImg(String img,String user_pho);

    void UpdateUser (String user_name,String user_mail,String user_pho);

}
