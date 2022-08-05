package com.example.androidframework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //注释 备注 测试
    private Button btn_watermark;

    //测试提交代码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_watermark=findViewById(R.id.btn_watermark);
        btn_watermark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,WatermarkActivity.class);
//                startActivity(intent);

            }
        });












    }
}