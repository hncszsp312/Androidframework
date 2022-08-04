package com.example.lib_customwidget.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.lib_customwidget.R;
import com.example.lib_customwidget.watermark.watermarkUtils;

public class WatermarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermark);
        watermarkUtils.setWatermark(this);
    }
}