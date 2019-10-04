package com.tomato.controller;

import com.github.pagehelper.PageInfo;
import com.tomato.entitys.Post;
import com.tomato.entitys.Reply;
import com.tomato.service.PostService;
import com.tomato.service.ReplyService;
import com.tomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {

    @Autowired(required=true)
    PostService postService;

    @Autowired(required=true)
    UserService userService;

    @Autowired
    ReplyService replyService;

    //查询所有员工返回列表页面
    @GetMapping("/main")
    public String list(@RequestParam(value = "pageNo" ,defaultValue = "1")int pageNum ,
                       @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
                       Model model){


        PageInfo<Post> page = postService.listPost(pageNum,pageSize);
//        List<Post> list = page.getList();
//       for (Post p:list
//        ) {
//            System.out.println(p.getUser().getUser_name());
//        }
        //将pageInfo放在请求域中

        model.addAttribute("pageInfo",page);
        //thymeleaf默认就会拼接串联路径
        //classpath:/tmplates/
        return "/main";
    }

    //来到帖子页面，查出帖子内容，页面显示
     //@PathVariable放入获取的值值
    @GetMapping("/post/{post_id}")
    public String toPost(@RequestParam(value = "pageNo" , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize" , defaultValue = "10") int pageSize,
                         @PathVariable("post_id") Integer post_id , Model model){

        Post post = postService.findById(post_id);
        System.out.println(post);
        model.addAttribute("post",post);
        PageInfo<Reply> replyPage = replyService.listReply(post_id, pageNum, pageSize);
        model.addAttribute("rePageInfo",replyPage);
        return "post/toPost";
    }

    @PostMapping("/doPost/{user_id}")
    public String doPost(@RequestParam("title") String title,
                         @RequestParam("p_content") String p_content,
                         @PathVariable("user_id") int user_id){

        postService.addPost(title,p_content,user_id);

        return "redirect:/main";

    }

    @GetMapping("/findPost")
    public String findByPostTitle(@RequestParam(value = "pageNo" , defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize" , defaultValue = "10") int pageSize,
                                  String findTitle,Model model){

        PageInfo<Post> posts=postService.findByPostTitle(findTitle,pageNum,pageSize);

        model.addAttribute("pageInfo2",posts);
        return "post/find";
    }

}
