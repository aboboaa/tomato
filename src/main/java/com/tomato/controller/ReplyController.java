package com.tomato.controller;

import com.tomato.mapper.ReplyMapper;
import com.tomato.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/doReply/{post_id}/{user_id}")
    public String doReply(@RequestParam("r_content") String r_content,
                          @PathVariable("post_id") int post_id,
                          @PathVariable("user_id") int user_id,
                          Model model){

        replyService.addReply(r_content,post_id,user_id);

        return "redirect:/post/" + post_id;

    }



}
