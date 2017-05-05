package com.fire.service;

import com.fire.entity.HistoryDateUtil;
import com.fire.pojo.ShuichanData;

import java.util.List;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 数据展示的业务层接口
 */


public interface DataService {
    /**
     * 功能描述：
     * 历史数据分页查询接口
     */
    List<ShuichanData> queryHistoryDataByPage(Map<String, Object> parameter) throws Exception;


    /**
     * 功能描述：
     * 历史数据查询接口
     */
    List<ShuichanData> queryHistoryData(HistoryDateUtil historyDateUtil) throws Exception;

    //查询汇聚表数据接口
    List<ShuichanData> queryIntegration(HistoryDateUtil historyDateUtil)throws Exception;

    //查询出当前最新的数据
    List<ShuichanData> queryCurrentData(HistoryDateUtil historyDateUtil)throws Exception;

    //查询出指定时间段的数据
    List<ShuichanData> queryAppointedTime(HistoryDateUtil historyDateUtil)throws Exception;
}
