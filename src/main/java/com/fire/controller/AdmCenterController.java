package com.fire.controller;

import com.fire.pojo.Pound;
import com.fire.pojo.User;
import com.fire.service.PoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZC on 2017/4/6.
 */
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

    //改变鱼塘的所有权
    @RequestMapping(value = "changeOwner")
    public
    @ResponseBody
    String changeOwner(Integer id, String userName) throws Exception {

        poundService.changeOwner(id, userName);
        String isNull = "success";
        return isNull;

    }


    //添加一个鱼塘
    @RequestMapping(value = "addPound")
    public
    @ResponseBody
    String addPound(Pound pound) throws Exception {
       /* pound.setProvince("222222南京");
        pound.setCountry("000000ns");
        pound.setPoundLength(300);
        pound.setPoundDeep(30);
        pound.setUserName("zhangsan");
        pound.setTel("13111111111");
        pound.setUserName("chenliu");
        pound.setAddress("zhang");
        pound.setCity("nanjing");
        pound.setPoundName("ssr");
        pound.setEmail("123@qq.com");
        pound.setEnterpriseName("zc");
        pound.setPoundArea(123455);
        pound.setUserId(2);*/
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
        /*pound.setId(118);
        pound.setPoundName("urrr");
        pound.setAddress("ssssssss");*/
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

        poundService.addUser(user);
        String isNull = "success";
        return isNull;
    }

    @RequestMapping(value = "deleteUser")
    public
    @ResponseBody
    String deleteUserById(Integer id) throws Exception {
        id = 11;
        poundService.deleteUserById(id);
        String isNull = "success";
        return isNull;
    }
}
