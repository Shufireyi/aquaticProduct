package com.fire.service.impl;

import com.fire.mapper.DataMapper;
import com.fire.po.ShuichanData;
import com.fire.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;
    public List<ShuichanData> queryHistoryDataByPage(Map<String, Object> parameter) throws Exception {
        return dataMapper.queryHistoryDataByPage(parameter);
    }
}
