package com.tomato.controller;


import com.aliyuncs.exceptions.ClientException;
import com.tomato.entitys.User;
import com.tomato.service.UserService;
import com.tomato.util.AliyunSmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.io.*;


import org.springframework.web.multipart.MultipartFile;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public String login(@RequestParam("user_pho") String user_pho,
                        @RequestParam("user_paswd") String user_paswd,
                        Map<String,Object> map, HttpSession session) {

        User user = userService.checkLogin(user_pho,user_paswd);

        if (user != null) {
            //登录成功
            session.setAttribute("user_name",user.getUser_name());
            session.setAttribute("user_id",user.getUser_id());
            session.setAttribute("user_pho",user.getUser_pho());
            session.setAttribute("email",user.getUser_email());
            session.setAttribute("user",user);
            return "redirect:/main";
        } else {
            //登录失败
            map.put("msg","用户名密码错误！");
            return "login";
        }

    }

//    @RequestMapping("/init")
//    public String init(){
//        return "login";
//    }

    @RequestMapping("user/regist")
    public String regist(){
        return "register";
    }

    @RequestMapping("/info")
    public String inie(){
        return "info";
    }

    @RequestMapping("user/forget")
    public String forget(){
        return "forget";
    }
    @RequestMapping("/nfoDeit")
    public String info(){
        return "infoDeit";
    }

    @PostMapping("/user/doRegist")
    public String doRegist(User user, @RequestParam("code") String code, HttpSession session,
                           HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        if (code.equals(session.getAttribute("backcode"))) {
            if (userService.findByUserPhone(user.getUser_pho())==true) {
                userService.regist(user);
                response.getWriter().write("<script>alert('注册成功！');</script>");
                return "login";
            }
            else {
                response.getWriter().write("<script>alert('该手机已被注册！');</script>");
                return "register";
            }

        } else {
            response.getWriter().write("<script>alert('服务器忙，请稍候重试！');</script>");
            return  "register";
        }


    }

    @GetMapping("/send")
    @ResponseBody
    public String send(String user_pho, HttpSession session) throws ClientException, IOException{
        String backcode = AliyunSmsUtils.sendSms(user_pho);
        session.setAttribute("backcode", backcode);
        return  "Success";
    }

    //上传
    @RequestMapping("/uploadimg")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
    public String uploadimg(@RequestParam(value="file") MultipartFile file, HttpServletRequest request, HttpSession session) throws IOException {
        String pho = (String) session.getAttribute("user_pho");
        User user =userService.findByUserPh(pho);

        if(file!=null&&file.getSize()>0) {
            String filename=file.getOriginalFilename();
            //"image/photo/"+
            if (filename.endsWith(".png")||filename.endsWith(".jpg")) {
                InputStream is=file.getInputStream();
                String photopath="C:/java/"+filename;
                OutputStream os=new FileOutputStream(photopath);

                byte[] bs=new byte[1024];
                int len=-1;
                while((len=is.read(bs))!=-1) {
                    os.write(bs, 0, len);
                }
                os.close();
                is.close();
                user.setImg(photopath);
                userService.UpdateUserImg(user.getImg(),user.getUser_pho());
                System.out.println("上传成功,路径为:"+photopath);
            }

        }
        //request.getSession().setAttribute("message","修改成功");
        // request.getSession().setAttribute("url","Student/listStudent");
        return  "info";

    }

    //头像回显
    @ResponseBody
    @RequestMapping("/getPhotoImage")
    public void getPhotoImage(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        String pho = (String) session.getAttribute("user_pho");
        User user =userService.findByUserPh(pho);
        String photo=user.getImg();

       /* if (photo==null) {
            photo="D:/java/default/person.png";
        }*/
        InputStream is=new FileInputStream(photo);
        OutputStream os=response.getOutputStream();
        byte[] bs=new byte[1024];
        int len=-1;
        while((len=is.read(bs))!=-1) {
            os.write(bs, 0, len);
        }
        os.close();
        is.close();

    }

    @PostMapping("editUser")
    public String editUser(@RequestParam("user_name")String user_name,
                           @RequestParam("user_mail")String user_mail,
                           HttpSession session){
            String userPho=(String)session.getAttribute("user_pho");
            userService.UpdateUser(user_name,user_mail,userPho);

        return "info";
    }
}
