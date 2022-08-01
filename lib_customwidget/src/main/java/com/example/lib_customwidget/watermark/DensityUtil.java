package com.example.lib_customwidget.watermark;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * ============================================================
 * <p/>
 * 版 权 ：2022
 * <p/>
 * 作 者 ：zhonghsuiping
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
public class DensityUtil {

    private DensityUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     */
    public static int dp2px(float dpVal) {
        return (int) (0.5f + dpVal * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * sp转px
     */
    public static int sp2px(float spVal) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, Resources.getSystem().getDisplayMetrics()) + 0.5F);
    }

    /**
     * px转dp
     */
    public static int px2dp(float pxVal) {
        return (int) (pxVal / Resources.getSystem().getDisplayMetrics().density + 0.5F);
    }

    /**
     * px转sp
     */
    public static int px2sp(float pxVal) {
        return (int) (pxVal / Resources.getSystem().getDisplayMetrics().scaledDensity + 0.5F);
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
