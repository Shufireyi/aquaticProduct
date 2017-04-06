package com.fire.controller;

import com.fire.po.User;
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
public class UsersController {

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
        User user1 = new User();
        user1.setUserName("shufangyi");
        user1.setPassword("shufangyi");
        user1.setPower(1);
        User rs = userService.findUserByNameAndPassword(user1);
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
    public String logout(HttpSession session) throws Exception {
        // 清除session
        session.invalidate();
        return "redirect:../index.html";
    }

    /**
     * 功能描述：
     * 用户注册
     */
    @RequestMapping(value = "register")
    public
    @ResponseBody
    String register(User user) throws Exception {
        /**
         * 设置注册时间
         */
        //Date nDate = new Date();
        //user.setCreateTime(nDate);
        //System.out.println(nDate);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowTime = format1.format(new Date());
        //System.out.println(nowTime);

        User user1 = new User();
        user1.setUserName("shufangyi");
        user1.setPassword("shufangyi");
        user1.setPersonName("shufnagyi");
        user1.setPower(1);
        user1.setTel("13151562908");
        user1.setEmail("102338496@qq.com");
        user1.setEnterpriseName("南区10栋");
        user1.setCreateTime(nowTime);
        int rs = userService.register(user1);
        String isNull = "error";
        if (rs == 1) {
            isNull = "success";
        } else {
            isNull = "fail";
        }
        return isNull;
    }


}