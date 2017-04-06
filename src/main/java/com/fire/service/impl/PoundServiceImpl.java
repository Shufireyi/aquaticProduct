package com.fire.service.impl;

import com.fire.mapper.PoundMapper;
import com.fire.pojo.Pound;
import com.fire.service.PoundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public class PoundServiceImpl implements PoundService {
    /**
     * 2017/4/6
     * ZC
     * 1.通过用户名查询所拥有的鱼塘列表
     * 2.管理员对鱼塘的增删改查功能
     * 3.鱼塘所有权的转让
     **/

    @Autowired
    private PoundMapper poundMapper;

    public List<Pound> queryPoundByUsername(String userName) throws Exception {
        int id = poundMapper.findIdByUsername(userName);
        List<Pound> poundList = poundMapper.queryPoundByUserId(id);
        return poundList;
    }


    public void addPound(Pound pound) throws Exception {
        poundMapper.addPound(pound);
    }

    public void deletePound(int id) throws Exception {
        poundMapper.deletePound(id);
    }

    public void updatePound(Pound pound) throws Exception {
        poundMapper.updatePound(pound);
    }

    public List<Pound> queryPound() throws Exception {
        return poundMapper.queryPound();
    }

}
