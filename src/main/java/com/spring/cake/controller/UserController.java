package com.spring.cake.controller;

import com.bilibili.yl.entity.ResultEntity;
import com.bilibili.yl.enums.ResultEnum;
import com.bilibili.yl.util.MailUtils;
import com.spring.cake.entity.UsersEntity;
import com.spring.cake.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("login")
    public ResultEntity<String> login() {
        return null;
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

}
