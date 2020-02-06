package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.FlatButton;

public class SchoolAdminHome extends BaseActivity {

    private static final CharSequence PASS_SCHOOL ="school@123";
    private FlatButton submit_btn;
    private EditText email;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_admin_home);

        submit_btn = findViewById(R.id.submit);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


        if(password.getText().toString().contains(PASS_SCHOOL)&& (!TextUtils.isEmpty(email.getText()))){

            startActivity(new Intent(SchoolAdminHome.this,SchoolAttendance.class));
        }else
        {
            Toast.makeText(SchoolAdminHome.this,"Password or email incorrect, try again",Toast.LENGTH_SHORT).show();
        }}
        });

    }
}
