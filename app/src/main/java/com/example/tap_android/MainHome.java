package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.grpc.SynchronizationContext;


public class MainHome extends AppCompatActivity {
    CardView questioncv;
    CardView autocomcv;
    CardView callcv;
    CardView attendancecv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        questioncv=findViewById(R.id.question_cv);
        autocomcv=findViewById(R.id.autocom_cv);
        callcv=findViewById(R.id.callcv);
        attendancecv=findViewById(R.id.att_cv);
        callcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainHome.this,CallActivity.class);
                startActivity(intent);
            }
        });
        questioncv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainHome.this,com.example.tap_android.Tap_Home.class);
                startActivity(intent);
            }
        });

        autocomcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHome.this, com.example.tap_android.Whatsapp.class);
                startActivity(intent);
            }
        });
        attendancecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainHome.this, SchoolAttendance.class);
                startActivity(intent);
            }
        });



    }
}
