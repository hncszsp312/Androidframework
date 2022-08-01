package com.example.lib_customwidget.watermark;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


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
public class WatermarkDrawable extends Drawable {

    public Paint mPaint;
    /**
     * 水印文本
     */
    public String mText;
    /**
     * 字体颜色，十六进制形式，例如：0xAEAEAEAE
     */
    public int mTextColor;
    /**
     * 字体大小，单位为sp
     */
    public float mTextSize;
    /**
     * 旋转角度
     */
    public float mRotation;

    WatermarkDrawable() {
        mPaint = new Paint();
    }

    @SuppressLint("NewApi")
    @Override
    public void draw(@NonNull Canvas canvas) {

        int width = getBounds().right ;
        int height = getBounds().bottom ;
        int diagonal = (int) Math.sqrt(width * width + height * height); // 对角线的长度
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(ConvertUtils.spToPx(mTextSize)); // ConvertUtils.spToPx()这个方法是将sp转换成px，ConvertUtils这个工具类在我提供的demo里面有
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        float textWidth = mPaint.measureText(mText);
        canvas.drawColor(0x00000000);
        canvas.rotate(mRotation);
        //canvas.drawRoundRect(50,50,50,50,300,300,mPaint);
        int index = 0;
        float fromX;
        // 以对角线的长度来做高度，这样可以保证竖屏和横屏整个屏幕都能布满水印
        for (int positionY = diagonal / 10 ; positionY <= diagonal; positionY += diagonal / 10  ) {
            fromX = -width + (index++ % 2) * textWidth; // 上下两行的X轴起始点不一样，错开显示
            for (float positionX = fromX; positionX < width; positionX += textWidth * 2) {
                canvas.drawText(mText, positionX , positionY , mPaint);
            }
        }
        canvas.save();
        canvas.restore();
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}

