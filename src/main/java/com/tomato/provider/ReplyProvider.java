package com.tomato.provider;

import com.tomato.entitys.Reply;
import org.apache.ibatis.jdbc.SQL;

public class ReplyProvider {

    public String updateReply(final Reply reply) {

        return new SQL() {
            {

                //条件语法
                UPDATE("reply");

                if (reply.getReply_id() != null) {
                    SET("reply_id=#{reply_id}");
                }

                if (reply.getR_content() != null) {
                    SET("r_content=#{r_content}");
                }

                if (reply.getTime() != null) {
                        SET("time=#{time}");
                }

                if (reply.getUser() != null) {
                    SET("user_id=#{user_id}");
                }

                if (reply.getPost_id() != null) {
                    SET("post_id=#{post_id}");
                }
                if (reply.getP_click_count() != null) {
                    SET("P_click_count=#P_click_count{}");
                }

                WHERE("reply_id=#{reply_id}");
                }
                        }.toString();
                    }


    public String insertReply ( final Reply reply){

        return new SQL() {
            {

                //条件语法
                INSERT_INTO("reply");


                //多个写法.
                INTO_COLUMNS( "r_content", "user_id", "time", "p_click_count", "post_id");
                INTO_VALUES( "#{r_content}", "#{user.user_id}", "#{time}", "#{p_click_count}", "#{post_id}");

            } }.toString();

    }

}







