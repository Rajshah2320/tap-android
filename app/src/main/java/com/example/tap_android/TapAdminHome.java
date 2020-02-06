package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.FlatButton;

public class TapAdminHome extends AppCompatActivity {
    EditText email;
    EditText password;
    FlatButton submit;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_admin_home);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass=password.getText().toString();
                if(pass.equals("admin@123")){
                    Intent intent=new Intent(TapAdminHome.this,MainHome.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(TapAdminHome.this,"LOGIN not Successful",Toast.LENGTH_SHORT).show();
            }}
        });
    }
}

