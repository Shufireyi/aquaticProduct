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
}
