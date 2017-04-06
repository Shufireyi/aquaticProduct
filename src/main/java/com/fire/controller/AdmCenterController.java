package com.fire.controller;

import com.fire.pojo.Pound;
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

    @RequestMapping(value = "addPound")
    public
    @ResponseBody
    String addPound(Pound pound) throws Exception {
        poundService.addPound(pound);
        String isNull = "success";
        return isNull;
    }

    @RequestMapping(value = "deletePound")
    public
    @ResponseBody
    String deletePound(int id) throws Exception {
        poundService.deletePound(id);
        String isNull = "success";
        return isNull;
    }

    @RequestMapping(value = "updatePound")
    public
    @ResponseBody
    String updatePound(Pound pound) throws Exception {
        poundService.updatePound(pound);
        String isNull = "success";
        return isNull;
    }

    @RequestMapping(value = "queryPound")
    public
    @ResponseBody
    List<Pound> queryPound() throws Exception {
        return poundService.queryPound();
    }
}
