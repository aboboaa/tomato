package com.tomato.mapper;


import com.tomato.entitys.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    //通过id查找用户
    @Select("select user_id,user_name,user_paswd,user_pho,user_email,user_sex from user where user_id=#{user_id}")
    User findByUserId(int user_id);

    //通过用户名查找用户和密码
    @Select("select user_id,user_name,user_paswd,user_pho from user where username=#{username}")
    User findByUsername(String username);

    //通过手机查找用户和密码
    @Select("select user_id,user_name,user_paswd,user_pho from user where user_pho=#{user_pho}")
    User findByUserPhone(String user_pho);

    //注册用户和密码
    @Insert("insert into user (user_name,user_pho,user_paswd) values (#{user_name},#{user_pho},#{user_paswd})")
    void registerByUsernameAndPassword(@Param("user_name") String user_name,@Param("user_pho") String user_pho,
                                       @Param("user_paswd") String user_paswd);


    //通过手机查找用户和密码
    @Select("select user_id user_name,user_paswd,user_pho,img from user where user_pho=#{user_pho}")
    User findByUserPh(String user_pho);



//上传图片
    @Update("update user set img=#{img} where user_pho=#{user_pho}")
    void  UpdateUserImg (@Param("img") String img,@Param("user_pho") String user_pho );

    //修改用户
    @Update("update user set user_name=#{user_name},user_mail=#{user_mail} wherer user_pho=#{user_pho}")
    void UpdateUser(@Param("user_name") String user_name,@Param("user_mail") String user_mail,@Param("user_pho") String user_pho);
}
