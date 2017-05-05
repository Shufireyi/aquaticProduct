package com.fire.service.impl;

import com.fire.entity.HistoryDateUtil;
import com.fire.mapper.DataMapper;
import com.fire.pojo.ShuichanData;
import com.fire.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 * dataService 接口实现
 */


public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    public List<ShuichanData> queryHistoryDataByPage(Map<String, Object> parameter) throws Exception {
        return dataMapper.queryHistoryDataByPage(parameter);
    }

    public List<ShuichanData> queryHistoryData(HistoryDateUtil historyDateUtil) throws Exception {
        return dataMapper.queryHistoryData(historyDateUtil);
    }

    //查询汇聚表中数据
    public  List<ShuichanData> queryIntegration(HistoryDateUtil historyDateUtil)throws Exception{
        return dataMapper.queryIntegration(historyDateUtil);

    }
    //查询出最新的数据
    public List<ShuichanData> queryCurrentData(HistoryDateUtil historyDateUtil)throws Exception{
        List<ShuichanData> list= new ArrayList<ShuichanData>();
        ShuichanData list_tmp=dataMapper.queryCurrentPh(historyDateUtil);
        //List<ShuichanData> list_tmp=dataMapper.queryCurrentPh(historyDateUtil);
        list.add(list_tmp);
        System.out.println("==========="+list_tmp.getTime());
        //list.add(list_tmp.get(list_tmp.size()-1));
        //list_tmp.clear();
        ShuichanData list_tmp2=dataMapper.queryCurrentDo2(historyDateUtil);
        list.add(list_tmp2);
        System.out.println("========"+list_tmp2.getTime());
        //list.add(list_tmp.get(list_tmp.size()-1));
        //list_tmp.clear();
        ShuichanData list_tmp3=dataMapper.queryCurrentWater(historyDateUtil);
        list.add(list_tmp3);
        System.out.println("=========="+list_tmp3.getTime());
        //list.add(list_tmp.get(list_tmp.size()-1));
        //list_tmp.clear();
        return list;
    }

    //查询出特定时间段的数据
    public List<ShuichanData> queryAppointedTime(HistoryDateUtil historyDateUtil)throws Exception {
        return dataMapper.queryAppointedTime(historyDateUtil);

    }

}











