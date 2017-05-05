package com.fire.controller;

import com.fire.entity.HistoryDateUtil;
import com.fire.entity.Page;
import com.fire.pojo.ShuichanData;
import com.fire.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Map<String, Object> parameter = new HashMap<String, Object>();
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

    /*
    * 添加功能
    * 时间：2017-4-28
    * 功能：对汇聚表的查询、获取最新数据、时间段间隔查询
    * **/
    //查询出历史表中的数据
    @RequestMapping(value = "queryHistoryData")
    public
    @ResponseBody
    List<ShuichanData> queryHistoryData(HistoryDateUtil historyDateUtil) throws Exception {
        /*HistoryDateUtil historyDateUtil1 = new HistoryDateUtil();
        historyDateUtil.setComid("2");
        historyDateUtil.setFacid("1");
        historyDateUtil.setSuffix(1);
        historyDateUtil.setStartTime("2017-04-09 00:00:00");
        historyDateUtil.setEndTime("2017-04-11 00:00:00");*/

        System.out.println(historyDateUtil.getFacid());
        List<ShuichanData> list = dataService.queryHistoryData(historyDateUtil);
        return list;
    }

    //查询出汇聚表中的数据(时间跨度超过一个月)
    @RequestMapping(value="queryIntegration")
    public @ResponseBody List<ShuichanData> queryIntegration(HistoryDateUtil historyDateUtil)throws Exception{
       /*historyDateUtil.setFacid("2");
       historyDateUtil.setComid("2");
       historyDateUtil.setStartTime("2017-2-22 00:00:00");
       historyDateUtil.setEndTime("2017-03-30 00:00:00");*/
        List<ShuichanData> list=dataService.queryIntegration(historyDateUtil);
        return list;

    }

    //查询出最新的数据
    @RequestMapping(value = "queryCurrentData")
    public @ResponseBody List<ShuichanData> queryCurrentData(HistoryDateUtil historyDateUtil)throws Exception{
        /*historyDateUtil.setFacid("1");
        historyDateUtil.setSuffix(1);
        historyDateUtil.setComid("2");*/
        List<ShuichanData>list= dataService.queryCurrentData(historyDateUtil);
        System.out.println(list.get(1)+"--------------");
        return list;
    }

    //时间间隔查询
    @RequestMapping(value = "queryAppointedTime")
    public @ResponseBody Map<String,List<ShuichanData>> queryAppointedTime(HistoryDateUtil historyDateUtil)throws Exception{
       /* historyDateUtil.setComid("2");
        historyDateUtil.setFacid("1");
        historyDateUtil.setSuffix(1);
        historyDateUtil.setStartTime("2017-04-01 00:00:00");
        historyDateUtil.setEndTime("2017-04-07 01:00:00");
        */
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = fmt.parse(historyDateUtil.getStartTime());
        Date endTime=fmt.parse(historyDateUtil.getEndTime());
        int i=0,j=0;
        Calendar   calendar   =   new   GregorianCalendar();
        calendar.setTime(endTime);
        while(startTime.compareTo(endTime)<0){
            i++;
            calendar.add(calendar.DATE,-1);
            endTime=calendar.getTime();
        }
        calendar.setTime(endTime);
        calendar.add(calendar.DATE,1);
        endTime=calendar.getTime();
        HistoryDateUtil historyDate=new HistoryDateUtil();
        List<ShuichanData> list=new ArrayList<ShuichanData>();
        Map<String,List<ShuichanData>> map=new HashMap<String, List<ShuichanData>>();
        for (j=0;j<i;j++){
            /*historyDate.setStartTime(fmt.format(startTime));
            historyDate.setEndTime(fmt.format(endTime));
            historyDate.setComid(historyDateUtil.getComid());
            historyDate.setFacid(historyDateUtil.getFacid());
            if (historyDateUtil.getFacid()=="1") historyDate.setSuffix(historyDateUtil.getSuffix());
            list=dataService.queryAppointedTime(historyDate); */
            historyDateUtil.setStartTime(fmt.format(startTime));
            historyDateUtil.setEndTime(fmt.format(endTime));
            list=dataService.queryAppointedTime(historyDateUtil);
            map.put(j+"",list);
            list=null;
            calendar.setTime(startTime);
            calendar.add(calendar.DATE,1);
            startTime=calendar.getTime();
            calendar.setTime(endTime);
            calendar.add(calendar.DATE,1);
            endTime=calendar.getTime();
        }
        return map;


    }

}
