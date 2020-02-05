package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AutoCom extends AppCompatActivity {

    Button btnWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_com);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AutoCom.this, Whatsapp.class);
                startActivity(intent);
            }
        });

    }
}
