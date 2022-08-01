package com.example.lib_customwidget.watermark;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;

/**
 * ============================================================
 * <p/>
 * 版 权 ：2022年
 * <p/>
 * 作 者 ：zhongshuiping
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 工号：
 * <p/>
 * 创建日期 ： $
 * <p/>
 * 描 述 ：$水印
 * <p/>
 * 包名 ：$
 * <p/>
 * 修订历史 ：
 * <p/>
 * ============================================================
 **/
public class watermarkUtils {


    //    显示水印，铺满整个页面(首页模板 显示在中间)
    public static void setWatermark(Activity context) {
        //快递员姓名
        String mineUsername = "湖南省长沙市望城区";
        String userWatermarkName = "";
        String userCode = "123456";
        if(!TextUtils.isEmpty(userCode)&&!TextUtils.isEmpty(userCode)){
             userWatermarkName=mineUsername+"&&"+userCode;
        }else{
            userWatermarkName=userCode;
        }

        Watermark.getInstance()
                .setText(userWatermarkName)
                .setTextColor(0x15999966)
                .setTextSize(14)
                .setRotation(-45)
                .show(context);
    }

    //    显示水印，根据尺寸铺满页面（其他页面模板显示在靠底部间）
    public static void setWatermark(Activity context, String userName, int type) {

        Watermark.getInstance()
                .setText(userName)
                .setTextColor(Color.parseColor("#b8b7b7"))
                //.setTextColor(0xAE000000)
                .setTextSize(14)
                .setRotation(-45)
                .showTwo(context);
    }
}
