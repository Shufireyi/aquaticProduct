package com.fire.controller;

import com.fire.po.HistoryDateUtil;
import com.fire.po.Page;
import com.fire.po.ShuichanData;
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

    @RequestMapping(value = "queryHistoryDataByPage")
    public
    @ResponseBody
    List<ShuichanData> queryHistoryDataByPage(HistoryDateUtil historyDateUtil, Page page) throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        HistoryDateUtil historyDateUtil1 = new HistoryDateUtil();
        Page page1 = new Page();
        page1.setCurrentPage(1);
        historyDateUtil1.setComid("2");
        historyDateUtil1.setFacid("1");
        historyDateUtil1.setType("ph");
        //historyDateUtil1.setStartDate("2017-01-19");
        historyDateUtil1.setStartTime("2017-01-19 0:0:0");
        //historyDateUtil1.setEndDate("2017-01-20");
        historyDateUtil1.setEndTime("2017-01-20 23:0:0");
        parameter.put("util", historyDateUtil1);
        parameter.put("page", page1);
        List<ShuichanData> list = dataService.queryHistoryDataByPage(parameter);
        return list;
    }
}
