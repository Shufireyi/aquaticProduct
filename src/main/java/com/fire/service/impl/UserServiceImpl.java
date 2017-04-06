package com.fire.service.impl;

import com.fire.mapper.UserMapper;
import com.fire.po.User;
import com.fire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User findUserByNameAndPassword(User user) throws Exception {
        return userMapper.findUserByNameAndPassword(user);
    }

    public int updateUserTimeRecord(User user) throws Exception {
        //接着这里写，用户登录的时候更新登陆次数和时间
        return 0;
    }

    public int register(User user) throws Exception{
        return userMapper.register(user);
    }
}
