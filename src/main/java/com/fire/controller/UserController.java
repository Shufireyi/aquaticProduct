package com.fire.controller;

import com.fire.pojo.User;
import com.fire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 用户管理
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 功能描述：
     * 用户登录
     */
    @RequestMapping(value = "checklogin")
    public
    @ResponseBody
    String checkLogin(HttpSession session, User user) throws Exception {
        User rs = userService.findUserByNameAndPassword(user);
        String isNull = "error";
        if (rs != null) {
            session.setAttribute("nowUser", rs.getUserName());
            userService.updateUserLoginRecord(rs);
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
    @RequestMapping(value = "logout")
    public
    @ResponseBody
    String logout(HttpSession session) throws Exception {
        // 清除session
        session.invalidate();
        String isNull = "success";
        return isNull;
    }

    /**
     * 功能描述：
     * 用户注册
     */
    @RequestMapping(value = "register")
    public
    @ResponseBody
    String register(User user) throws Exception {

        // 设置注册时间
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowTime = format1.format(new Date());
        user.setCreateTime(nowTime);
        int rs = userService.register(user);
        String isNull = "error";
        if (rs == 1) {
            isNull = "success";
        } else {
            isNull = "fail";
        }
        return isNull;
    }

    /**
     * 功能描述：
     * 用户修改密码
     */
    @RequestMapping(value = "changePassword")
    public
    @ResponseBody
    String changePassword(User user, String newPassword) throws Exception {
        int rs = userService.changePassword(user, newPassword);
        String isNull = "error";
        if (rs == 1) {
            isNull = "success";
        } else {
            isNull = "fail";
        }
        return isNull;
    }

}