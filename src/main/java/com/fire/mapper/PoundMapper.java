package com.fire.mapper;

import com.fire.po.Pound;

import java.util.List;

/**
 * Created by ZC on 2017/4/6.
 */
public interface PoundMapper {
    //通过用户名查询用户ID
    int findIdByUsername(String userName) throws Exception;

    //通过用户ID查询出所拥有的鱼塘list集合
    List<Pound> queryPoundByUserId(int userId) throws Exception;

    //鱼塘的增删改查功能
    void addPound(Pound pound) throws Exception;

    void deletePound(int id) throws Exception;

    void updatePound(Pound pound) throws Exception;

    List<Pound> queryPound() throws Exception;

}
