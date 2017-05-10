package com.fire.controller;

import com.fire.pojo.Pound;
import com.fire.service.PoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZC
 * 2017/4/6.
 */
@Controller
@RequestMapping(value = "/userCenter")
public class UserCenterController {
    @Autowired
    private PoundService poundService;

    @RequestMapping(value = "queryPoundByUsername")
    public
    @ResponseBody
    List<Pound> queryPoundByuserName(String userName) throws Exception {
       //userName="chenliu";
        return poundService.queryPoundByUsername(userName);
    }
}
