package com.spring.cake.controller;

import com.bilibili.yl.entity.ResultEntity;
import com.bilibili.yl.enums.ResultEnum;
import com.bilibili.yl.util.MD5Utils;
import com.bilibili.yl.util.MailUtils;
import com.bilibili.yl.util.VerifyUtils;
import com.spring.cake.model.UsersEntity;
import com.spring.cake.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("login")
    public ResultEntity<String> login(String pnum, String verify, UsersEntity user, HttpSession session, HttpServletResponse response) {
        ResultEntity<String> result = new ResultEntity<>();
        if (user != null) {
            if (user.getPassword() == null) {
                UsersEntity isExists = userService.checkMailIsExists(user.getMail());
                if (isExists != null) {
                    if (pnum.equals(session.getAttribute("code"))) {
                        result.setCode(1);
                        result.setMsg("登录成功");
                        session.setAttribute("user", isExists);
                        session.removeAttribute("code");

                    } else {
                        result.setCode(2);
                        result.setMsg("验证码不正确");
                    }
                } else {
                    result.setCodeAndMsg(ResultEnum.USER_NOT_EXIST);
                }
            } else {
                UsersEntity login = userService.login(user.getMail(), MD5Utils.MD5Encode(user.getPassword(), "utf-8"));
                if (verify != null && !verify.equals("") && verify.equalsIgnoreCase(session.getAttribute("verify").toString())) {
                    if (login != null) {
                        result.setCode(1);
                        result.setMsg("登录成功");
                        session.removeAttribute("verify");
                        session.setAttribute("user", login);
                        //免登陆搞起来
                        Cookie cookie = new Cookie("Token", login.getToken());
                        cookie.setPath("/");
                        cookie.setMaxAge(24 * 3600 * 7);
                        response.addCookie(cookie);
                    } else {
                        result.setCode(2);
                        result.setMsg("用户名或密码错误");
                    }
                } else {
                    result.setCode(3);
                    result.setMsg("验证码不正确");
                }
            }
        }
        return result;
    }


    @RequestMapping("register")
    public ResultEntity<String> register(String code, UsersEntity user, HttpSession session) {
        ResultEntity<String> result = new ResultEntity<>();
        if (code.equals(session.getAttribute("code"))) {
            UsersEntity reg_user = userService.register(user);
            if (reg_user != null) {
                result.setMsg("注册成功");
                result.setCode(0);
                session.removeAttribute("code");
            } else {
                result.setCodeAndMsg(ResultEnum.SYSTEM_INNER_ERROR);
            }
        } else {
            result.setMsg("验证码不正确");
            result.setCode(60001);
        }
        return result;
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public ResultEntity<String> sendMail(HttpSession session, String mail) {
        ResultEntity<String> result = new ResultEntity<>();
        try {
            String code = MailUtils.createRandomNum(6);
            MailUtils util = new MailUtils("534889865@qq.com", "exqapugmptnkcacd", mail, "cake商城验证码", "欢迎你申请cake商城的账号，你的邮箱验证码为：" + code + "，千万不要告诉别人哟!");
            util.send();
            session.setAttribute("code", code);
            result.setCode(0);
            result.setMsg("发送成功");
        } catch (Exception e) {
            result.setCodeAndMsg(ResultEnum.SYSTEM_INNER_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * MyDemoGo
     */
    /**
     * 验证邮箱是否已存在
     * 服务器内部500：NullPointerException:ResultEntity的code要设值
     *
     * @param mail
     * @return
     */
    @RequestMapping("checkMail")
    public ResultEntity<String> checkMail(String mail) {
        ResultEntity<String> result = new ResultEntity<>();
        UsersEntity user = userService.checkMailIsExists(mail);
        System.out.println(user);
        if (user != null) {
            result.setMsg("邮箱已存在");
            result.setCode(1);
        } else {
            result.setMsg("邮箱可用");
            result.setCode(2);
        }
        return result;
    }


    /**
     * 验证码
     */
    @RequestMapping("verifyCode")
    public void verifyCode(HttpServletResponse response, HttpSession session) {
        VerifyUtils verify = new VerifyUtils();
        BufferedImage image = verify.getImage();  //调用这个方法获取验证码
        String text = verify.getText();  //获取验证码上的文本信息
        session.setAttribute("verify", text);
        try {
            verify.output(image, response.getOutputStream());  //向浏览器输出图片
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
