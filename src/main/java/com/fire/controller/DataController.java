package com.fire.controller;

import com.fire.entity.HistoryDateUtil;
import com.fire.entity.Page;
import com.fire.pojo.ShuichanData;
import com.fire.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 历史数据展示的分页展示
 */


@Controller
@RequestMapping(value = "/dataDisplay")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 功能描述：
     * 分页查询鱼塘历史数据
     */
    @RequestMapping(value = "queryHistoryDataByPage")
    public
    @ResponseBody
    Map<String, Object> queryHistoryDataByPage(HistoryDateUtil historyDateUtil, Page page) throws Exception {
        Map<String, Object> parameter = new HashMap<>();
        //HistoryDateUtil historyDateUtil1 = new HistoryDateUtil();
        //Page page1 = new Page();
        //page1.setCurrentPage(1);
        //historyDateUtil1.setComid("2");
        //historyDateUtil1.setFacid("1");
        //historyDateUtil1.setType("ph");
        //historyDateUtil1.setStartTime("2017-01-19 0:0:0");
        //historyDateUtil1.setEndTime("2017-01-20 23:0:0");
        parameter.put("util", historyDateUtil);
        parameter.put("page", page);
        List<ShuichanData> list = dataService.queryHistoryDataByPage(parameter);
        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("list", list);
        returnValue.put("page", page);
        return returnValue;
    }

    @RequestMapping(value = "queryHistoryData")
    public
    @ResponseBody
    List<ShuichanData> queryHistoryData(HistoryDateUtil historyDateUtil) throws Exception {
        //HistoryDateUtil historyDateUtil1 = new HistoryDateUtil();
        List<ShuichanData> list = dataService.queryHistoryData(historyDateUtil);
        return list;
    }
}
