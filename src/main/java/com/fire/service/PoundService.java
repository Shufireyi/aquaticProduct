package com.fire.service;

import com.fire.po.Pound;

import java.util.List;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public interface PoundService {

    //通过用户名查询出所拥有的的鱼塘
    List<Pound> queryPoundByUsername(String userName) throws Exception;

    //鱼塘的添加、删除、查询、修改
    void addPound(Pound pound) throws Exception;

    void deletePound(int id) throws Exception;

    void updatePound(Pound pound) throws Exception;

    List<Pound> queryPound() throws Exception;
}
