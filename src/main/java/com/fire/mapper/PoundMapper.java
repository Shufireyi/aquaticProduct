package com.fire.mapper;

import com.fire.po.Pound;

import java.util.List;

/**
 * Created by ZC on 2017/4/6.
 */
public interface PoundMapper {
    //通过用户名查询用户ID
    public int findIdByUsername(String userName)throws Exception;
    //通过用户ID查询出所拥有的鱼塘list集合
    public List<Pound> queryPoundByUserId(int userId)throws Exception;

    //鱼塘的增删改查功能
    public void addPound(Pound pound)throws Exception;

    public void deletePound(int id)throws Exception;

    public void updatePound(Pound pound)throws Exception;

    public List<Pound> queryPound()throws Exception;

}
