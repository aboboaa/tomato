package com.tomato.service.impl;


import com.tomato.entitys.User;
import com.tomato.mapper.UserMapper;
import com.tomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;


    // 检验用户登录业务

    @Override
    public User checkLogin(String user_pho, String user_paswd) {

        User user = userMapper.findByUserPhone(user_pho);
        if (user != null && user.getUser_paswd().equals(user_paswd)){
            return user;
        }
        return null;
    }

    @Override
    public void regist(User user) {
        String user_name = user.getUser_name();
        String user_pho = user.getUser_pho();
        String user_paswd = user.getUser_paswd();
        userMapper.registerByUsernameAndPassword(user_name,user_pho,user_paswd);
    }
    public boolean findByUserPhone(String user_pho){
        if ( userMapper.findByUserPhone(user_pho)!=null){
            return  false;
        }   else {
            return  true;
        }

    }

    @Override
    public User findByUserPh(String user_pho) {

        return userMapper.findByUserPh(user_pho);
    }

    @Override
    public void UpdateUserImg(String img,String user_pho) {
        userMapper.UpdateUserImg(img,user_pho);
    }
    public void UpdateUser (String user_name,String user_mail,String user_pho){
        userMapper.UpdateUser(user_name,user_mail,user_pho);
    }
}
