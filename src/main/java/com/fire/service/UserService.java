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
}
