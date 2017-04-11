package com.fire.service.impl;

import com.fire.mapper.PoundMapper;
import com.fire.pojo.Pound;
import com.fire.pojo.User;
import com.fire.service.PoundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ShuFire
 * on 2017/4/6.
 * e-mail：102338496@qq.com
 * 内容说明：
 */


public class PoundServiceImpl implements PoundService {
    /**
     * 2017/4/6
     * ZC
     * 1.通过用户名查询所拥有的鱼塘列表
     * 2.管理员对鱼塘的增删改查功能
     * 3.鱼塘所有权的转让
     **/

    @Autowired
    private PoundMapper poundMapper;

    public List<Pound> queryPoundByUsername(String userName) throws Exception {
        int id = poundMapper.findIdByUsername(userName);
        List<Pound> poundList = poundMapper.queryPoundByUserId(id);
        return poundList;
    }


    public void addPound(Pound pound) throws Exception {
        poundMapper.addPound(pound);
    }

    public void deletePound(Integer id) throws Exception {
        poundMapper.deletePound(id);
    }

    public void updatePound(Pound pound) throws Exception {
        poundMapper.updatePound(pound);
    }

    public List<Pound> queryPoundLikeName(String poundName) throws Exception {
        return poundMapper.queryPoundLikeName(poundName);
    }

    //查询出所有的用户
    public List<User> queryUser()throws Exception{
        return poundMapper.queryUser();

    }

    public void addUser(User user)throws  Exception{
        poundMapper.addUser(user);
    }

    public void deleteUserById(Integer id)throws Exception{
        poundMapper.deleteUserById(id);
    }

    //通过username和鱼塘修改鱼塘的所有权
    public void changeOwner(Integer id,String userName)throws Exception{
        User user=poundMapper.queryUserByUserName(userName);
        System.out.println(user.getEnterpriseName());
        System.out.println(user.getPersonName());
        System.out.println(user.getEmail());
        System.out.println(user.getUserName());
        Pound pound=new Pound();
        pound.setId(id);
        pound.setEnterpriseName(user.getEnterpriseName());
        pound.setPersonName(user.getPersonName());
        pound.setUserName(user.getUserName());
        pound.setTel(user.getTel());
        pound.setUserId(user.getId());
        pound.setEmail(user.getEmail());

        poundMapper.updatePoundOwner(pound);
    }

}
