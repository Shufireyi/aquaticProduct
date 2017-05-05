package com.fire.mapper;

import com.fire.entity.HistoryDateUtil;
import com.fire.pojo.ShuichanData;

import java.util.List;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 数据展示dao接口
 */


public interface DataMapper {
    /**
     * 功能描述：
     * 历史数据分页查询的mapper接口
     */
    List<ShuichanData> queryHistoryDataByPage(Map<String, Object> parameter) throws Exception;

    /**
     * 功能描述：
     * 历史数据分页查询的mapper接口
     */
    List<ShuichanData> queryHistoryData(HistoryDateUtil historyDateUtil) throws Exception;

    //对汇聚表中的数据进行查询
    List<ShuichanData> queryIntegration(HistoryDateUtil historyDateUtil)throws Exception;

    //获取当前最新数据,分别是ph、溶解氧、水温
    ShuichanData queryCurrentPh(HistoryDateUtil historyDateUtil)throws Exception;
    ShuichanData queryCurrentDo2(HistoryDateUtil historyDateUtil)throws Exception;
    ShuichanData queryCurrentWater(HistoryDateUtil historyDateUtil)throws Exception;

    //根据时间段进行查询
    List<ShuichanData> queryAppointedTime(HistoryDateUtil historyDateUtil)throws Exception;
}
