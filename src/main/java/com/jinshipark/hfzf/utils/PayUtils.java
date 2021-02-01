package com.jinshipark.hfzf.utils;

import com.jinshipark.hfzf.model.JinshiParkSetting;

import java.util.Date;

public class PayUtils {

    public static Integer getDateOften(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        long resMin = diff / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return Math.toIntExact(resMin);
    }

    public static Double getRent(Date endDate, Date nowDate, JinshiParkSetting jinshiParkSetting) {
        if (endDate == null) {
            return 0.0;
        }
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
//        long day = diff / nd;
//        // 计算差多少小时
//        long hour = diff % nd / nh;
//        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
//        // 计算差多少秒//输出结果
//        long sec = diff % nd % nh % nm / ns;
        //总分钟数
        long allMin = diff / nm;
        double allDayMin = 1440;
        double dayCharge = 0;
//        double res = 0;
        double spareMin = allMin % allDayMin;
        if (allMin > allDayMin) {
            dayCharge = Math.floor(allMin / allDayMin) * jinshiParkSetting.getJpsAlldayLimit();
        }
        if (spareMin < jinshiParkSetting.getJpsFreeTime()) {
            return dayCharge;
        }
        if (spareMin <= jinshiParkSetting.getJpsFirstTime()) {
            return dayCharge + Double.valueOf(jinshiParkSetting.getJpsFirstCharge());
        } else {
            double sumTemp = Math.floor((spareMin - jinshiParkSetting.getJpsFirstTime()) / jinshiParkSetting.getJpsFollowTime()) + 1; //sumTemp是否能够取整数
            double nowCharge = sumTemp * jinshiParkSetting.getJpsFollowCharge() + jinshiParkSetting.getJpsFirstCharge();
            if (nowCharge > jinshiParkSetting.getJpsAlldayLimit()) {
                nowCharge = jinshiParkSetting.getJpsAlldayLimit();
            }   //当天费用大于20时取20
            return dayCharge + nowCharge;//之前天数的费用加上当天费用
        }
    }
}
