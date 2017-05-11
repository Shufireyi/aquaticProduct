package com.fire.mapper;

import com.fire.pojo.Pound;
import com.fire.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by ZC on 2017/4/6.
 */
public interface PoundMapper {
    //通过用户名查询用户ID
    int findIdByUsername(String userName) throws Exception;

    //通过用户ID查询出所拥有的鱼塘list集合
    List<Pound> queryPoundByUserId(int userId) throws Exception;

    User findUserByUName(String uname) throws Exception;

    //鱼塘的增删改查功能
    void addPound(Pound pound) throws Exception;

    void deletePound(Integer id) throws Exception;

    void updatePound(Pound pound) throws Exception;

    List<Pound> queryPoundLikeName(String poundName) throws Exception;

    //用户的添加删除查询
    void deleteUserById(Integer id) throws Exception;

    void addUser(User user) throws Exception;

    List<User> queryUser() throws Exception;

    void updateUser(Map<String, Object> temp) throws Exception;

    //更新鱼塘的所有权
    void updatePoundOwner(Pound pound) throws Exception;


    User queryUserByUserName(String userName) throws Exception;

}
