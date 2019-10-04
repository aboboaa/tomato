package com.tomato.provider;

import com.tomato.entitys.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.jdbc.SQL;

//Post构建动态sql语句
public class PostProvider {

    //更新（update）动态sql语句
    public String updatePost(final Post post){

        return new SQL(){
            {

                //条件语法
                UPDATE("psot");

                if (post.getTitle() != null) {
                    SET("title=#{title}");
                }

                if (post.getP_content() != null) {
                    SET("p_content=#{p_content}");
                }

                WHERE("post_id=#{post_id}");
            } }.toString();
        }


    public String insertPost(final Post post){

        return new SQL(){
            {

                //条件语法
                INSERT_INTO("post");


                //多个写法.
                INTO_COLUMNS("title","p_content","user_id","time","p_click_count");
                INTO_VALUES("#{title}","#{p_content}","#{user.user_id}","#{time}","#{p_click_count}");


            } }.toString();

    }

}
