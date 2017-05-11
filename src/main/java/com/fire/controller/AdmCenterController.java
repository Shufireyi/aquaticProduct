package com.fire.controller;

import com.fire.pojo.Pound;
import com.fire.pojo.User;
import com.fire.service.PoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/adm")
public class AdmCenterController {

    @Autowired
    private PoundService poundService;


    //查询所有的用户
    @RequestMapping(value = "queryUser")
    public
    @ResponseBody
    List<User> queryUser() throws Exception {
        return poundService.queryUser();
    }

    //用户的添加删除
    @RequestMapping(value = "addUser")
    public
    @ResponseBody
    String addUser(User user) throws Exception {
        /*user.setUserName("zc");
        user.setEmail("351133261@qq.com");
        user.setEnterpriseName("jinlingkeji");
        user.setPersonName("zhangcheng");
        user.setTel("110");
        user.setCount(1);
        user.setPassword("123456");
        user.setPower(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        user.setCreateTime(df.format(new Date()));
        */
        // 设置注册时间
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowTime = format1.format(new Date());
        user.setCreateTime(nowTime);
        poundService.addUser(user);
        String isNull = "success";
        return isNull;
    }

    @RequestMapping(value = "deleteUser")
    public
    @ResponseBody
    String deleteUserById(Integer id) throws Exception {
        //id = 11;
        poundService.deleteUserById(id);
        String isNull = "success";
        return isNull;
    }

    //修改用户信息
    @RequestMapping(value = "updateUser")
    public
    @ResponseBody
    String updateUser(int id, User user) throws Exception {
        String isNull = "error";
        poundService.updateUser(id, user);
        isNull = "success";
        return isNull;
    }


    //添加一个鱼塘
    @RequestMapping(value = "addPound")
    public
    @ResponseBody
    String addPound(Pound pound) throws Exception {
        String uname = pound.getUserName();
        User nuser = poundService.findUserByUName(uname);
        pound.setUserId(nuser.getId());
        pound.setPersonName(nuser.getPersonName());
        pound.setEnterpriseName(nuser.getEnterpriseName());
        pound.setEmail(nuser.getEmail());
        pound.setTel(nuser.getTel());
        // 设置注册时间
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowTime = format1.format(new Date());
        pound.setCreateTime(nowTime);

        poundService.addPound(pound);
        String isNull = "success";
        return isNull;
    }

    //通过id删除鱼塘
    @RequestMapping(value = "deletePound")
    public
    @ResponseBody
    String deletePound(Integer id) throws Exception {
        poundService.deletePound(id);
        String isNull = "success";
        return isNull;
    }

    //更新一个鱼塘的信息
    @RequestMapping(value = "updatePound")
    public
    @ResponseBody
    String updatePound(Pound pound) throws Exception {
        poundService.updatePound(pound);
        String isNull = "success";
        return isNull;
    }

    //模糊查询鱼塘
    @RequestMapping(value = "queryPound")
    public
    @ResponseBody
    List<Pound> queryPoundLikeName(String poundName) throws Exception {

        return poundService.queryPoundLikeName(poundName);
    }

    //改变鱼塘的所有权
    @RequestMapping(value = "changeOwner")
    public
    @ResponseBody
    String changeOwner(Integer id, String userName) throws Exception {
        poundService.changeOwner(id, userName);
        String isNull = "success";
        return isNull;
    }
}
