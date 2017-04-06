package com.fire.service;

import com.fire.po.User;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public interface UserService {
    /**
     * 功能描述：
     * 用户登录
     */
    User findUserByNameAndPassword(User user) throws Exception;

    /**
     * 功能描述：
     * 更新用户登录的时间以及登录的总次数
     */
    int updateUserLoginRecord(User user) throws Exception;

    /**
     * 功能描述：
     * 用户注册接口
     */
    int register(User user) throws Exception;
}
