package com.fire.service.impl;

import com.fire.mapper.UserMapper;
import com.fire.pojo.User;
import com.fire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ShuFire
 * on 2017/3/31.
 * e-mail：102338496@qq.com
 * 内容说明：
 * UserService实现类
 */


public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByNameAndPassword(User user) throws Exception {
        return userMapper.findUserByNameAndPassword(user);
    }

    /**
     * 功能描述：
     * 登录时 更新登录时间、上次登录时间、登陆次数
     */
    public int updateUserLoginRecord(User user) throws Exception {
        //接着这里写，用户登录的时候更新登陆次数和时间
        String lastLoginTime = user.getLoginTime();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = format1.format(new Date());
        System.out.println(loginTime);
        user.setLastLoginTime(lastLoginTime);
        user.setLoginTime(loginTime);

        int count = user.getCount();
        user.setCount(count + 1);
        return userMapper.updateUserLoginRecord(user);
    }

    public int register(User user) throws Exception {
        return userMapper.register(user);
    }

    public int changePassword(User user, String newPassword) throws Exception {
        Map<String,Object> temp = new HashMap<String,Object>();
        temp.put("uid",user.getId());
        temp.put("newPassword",newPassword);
        return userMapper.changePassword(temp);
    }
}
