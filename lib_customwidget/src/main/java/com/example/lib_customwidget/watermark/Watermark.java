package com.example.lib_customwidget.watermark;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * ============================================================
 * <p/>
 * 版 权 ：2022
 * <p/>
 * 作 者  zhonghsuiping
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
public class Watermark {
    /**
     * 水印文本
     */
    private String mText;
    /**
     * 字体颜色，十六进制形式，例如：0xAEAEAEAE
     */
    private int mTextColor;
    /**
     * 字体大小，单位为sp
     */
    private float mTextSize;
    /**
     * 旋转角度
     */
    private float mRotation;
    private static Watermark sInstance;

    private Watermark() {
        mText = "";
        mTextColor = 0xAEAEAEAE;
        mTextSize = 18;
        mRotation = -25;
    }

    public static Watermark getInstance() {
        if (sInstance == null) {
            synchronized (Watermark.class) {
                sInstance = new Watermark();
            }
        }
        return sInstance;
    }

    /**
     * 设置水印文本
     *
     * @param text 文本
     * @return Watermark实例
     */
    public Watermark setText(String text) {
        mText = text;
        return sInstance;
    }

    /**
     * 设置字体颜色
     *
     * @param color 颜色，十六进制形式，例如：0xAEAEAEAE
     * @return Watermark实例
     */
    public Watermark setTextColor(int color) {
        mTextColor = color;
        return sInstance;
    }

    /**
     * 设置字体大小
     *
     * @param size 大小，单位为sp
     * @return Watermark实例
     */
    public Watermark setTextSize(float size) {
        mTextSize = size;
        return sInstance;
    }

    /**
     * 设置旋转角度
     *
     * @param degrees 度数
     * @return Watermark实例
     */
    public Watermark setRotation(float degrees) {
        mRotation = degrees;
        return sInstance;
    }

    /**
     * 显示水印，铺满整个页面(首页模板 显示在中间)
     *
     * @param activity 活动
     */
    public void show(Activity activity) {
        show(activity, mText);
    }

    /**
     * 显示水印，根据尺寸铺满页面（其他页面模板显示在靠底部间）
     *
     * @param activity 活动
     */
    public void showTwo(Activity activity) {
        showTwo(activity, mText);
    }

    /**
     * 显示水印，铺满整个页面
     *
     * @param activity 活动
     * @param text     水印
     */
    public void show(Activity activity, String text) {
       WatermarkDrawable drawable = new WatermarkDrawable();
        drawable.mText = text;
        drawable.mTextColor = mTextColor;
        drawable.mTextSize = mTextSize;
        drawable.mRotation = mRotation;
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
//        int height = outMetrics.heightPixels;
        //这边做了一个适配工具类，可以实现到一个屏幕适配的一个效果
//        int top = DensityUtil.dp2px(80);
//        int bottom = DensityUtil.dp2px(60);
        ViewGroup rootView = activity.findViewById(android.R.id.content);
        FrameLayout layout = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CLIP_VERTICAL);
        //动态设置水印的上下左右
        layoutParams.setMargins(0, 0, 0, 0);
        layout.setLayoutParams(layoutParams);
        layout.setBackground(drawable);
        rootView.addView(layout);
    }

    /**
     * 显示水印，根据尺寸铺满页面
     *
     * @param activity 活动
     * @param text     水印
     */
    public void showTwo(Activity activity, String text) {
        WatermarkDrawable drawable = new WatermarkDrawable();
        drawable.mText = text;
        drawable.mTextColor = mTextColor;
        drawable.mTextSize = mTextSize;
        drawable.mRotation = mRotation;
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int top = DensityUtil.dp2px(80);
//        int bottom = DensityUtil.dp2px(60);
        ViewGroup rootView = activity.findViewById(android.R.id.content);
        FrameLayout layout = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CLIP_VERTICAL);
        layoutParams.setMargins(0, top, 0, 0);
        layout.setLayoutParams(layoutParams);
        layout.setBackground(drawable);
        rootView.addView(layout);
    }
}