package com.fire.mapper;

import com.fire.po.User;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public interface UserMapper {
    /**
     * 功能描述：
     * 用户登录mapper接口
     */
    User findUserByNameAndPassword(User user) throws Exception;

    /**
     * 功能描述：
     * 用户注册mapper接口
     */
    int register(User user) throws Exception;
}
