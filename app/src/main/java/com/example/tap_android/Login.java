package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button TapAdmin;
    Button SchoolAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TapAdmin=findViewById(R.id.tap_admin);
        SchoolAdmin=findViewById(R.id.school_admin);

        TapAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Login.this,TapAdminHome.class);
                startActivity(intent);
            }
        });
        SchoolAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Login.this,SchoolAdminHome.class);
                startActivity(intent);
            }
        });
    }
}
