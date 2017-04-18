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
}
