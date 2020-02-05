package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainHome extends AppCompatActivity {
    CardView questioncv;
    CardView autocomcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        questioncv=findViewById(R.id.question_cv);
        autocomcv=findViewById(R.id.autocom_cv);
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
                Intent intent = new Intent(MainHome.this, com.example.tap_android.AutoCom.class);
                startActivity(intent);
            }
        });


    }
}
