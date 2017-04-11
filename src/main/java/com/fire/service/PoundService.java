package com.fire.service;

import com.fire.pojo.Pound;
import com.fire.pojo.User;

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

    void deletePound(Integer id) throws Exception;

    void updatePound(Pound pound) throws Exception;

    List<Pound> queryPoundLikeName(String poundName) throws Exception;


    //对用户的添加删除查询
    List<User> queryUser()throws Exception;

    void addUser(User user)throws Exception;

    void deleteUserById(Integer id)throws Exception;


    public void changeOwner(Integer id, String userName)throws  Exception;
}
