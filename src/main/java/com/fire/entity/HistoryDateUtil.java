package com.fire.entity;

/**
 * Created by ShuFire
 * on 2017/3/28.
 * e-mail：102338496@qq.com
 * 内容说明：
 * 查询历史数据的限制条件
 */
public class HistoryDateUtil {
    public String comid;

    public String facid;
    public String type;
    private int suffix;   //type的后缀，用于区分固城河1、2
    //public String startDate;
    public String startTime;
    //public String endDate;
    public String endTime;

    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
    }

    public String getFacid() {
        return facid;
    }

    public void setFacid(String facid) {
        this.facid = facid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //public String getStartDate() {
    //    return startDate;
    //}
    //
    //public void setStartDate(String startDate) {
    //    this.startDate = startDate;
    //}

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    //public String getEndDate() {
    //    return endDate;
    //}
    //
    //public void setEndDate(String endDate) {
    //    this.endDate = endDate;
    //}

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }
}
