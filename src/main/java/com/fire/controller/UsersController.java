package com.fire.controller;

import com.fire.po.User;
import com.fire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 用户管理
 */
@Controller
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    private UserService userService;


    /**
     * 功能描述：
     * 用户登录
     */
    @RequestMapping(value = "/CheckLogin")
    public
    @ResponseBody
    String CheckLogin(HttpSession session, User user) throws Exception {
        //测试用例
        //User user1 = new User();
        //user1.setUserName("chenliu");
        //user1.setPassword("chenliu");
        //user1.setPower(1);
        User rs = userService.findUserByNameAndPassword(user);
        String isNull = "error";
        if (rs != null) {
            session.setAttribute("nowUser", rs.getUserName());
            isNull = "success";
        } else {
            isNull = "fail";
        }
        return isNull;
    }


    /**
     * 功能描述：
     * 用户退出
     */
    @RequestMapping(value = "userLogout")
    public String logout(HttpSession session) throws Exception {
        // 清除session
        session.invalidate();
        return "redirect:../index.html";
    }


}