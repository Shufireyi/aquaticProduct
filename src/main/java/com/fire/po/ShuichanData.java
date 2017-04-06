package com.fire.po;

import java.util.Date;

/**
 * Created by ShuFire
 * on 2017/3/28.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 新数据库历史数据查询
 */
public class ShuichanData {
    private int id;
    private int companyid;
    private int factoryid;
    private int sensorid;
    private String type;
    private double value;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(int factoryid) {
        this.factoryid = factoryid;
    }

    public int getSensorid() {
        return sensorid;
    }

    public void setSensorid(int sensorid) {
        this.sensorid = sensorid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
