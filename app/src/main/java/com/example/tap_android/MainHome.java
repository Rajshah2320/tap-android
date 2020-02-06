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
                openWhatsappContact();
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

    void openWhatsappContact() {
        String text = "Updates for club this Saturday\n" +
                "\n" +
                "Coding : \n" +
                "1. Neerav shah  920008690\n" +
                "2. Bhavi Dave     678901234\n" +
                "3. Rahul Jain      987654321\n" +
                "\n" +
                "Dance \n" +
                "1. Shyam shah   787919199\n" +
                "2. Mohini Jha     7281919191\n" +
                "\n" +
                "Public speaking \n" +
                "1. Jheel shah  920008690\n" +
                "2. Bhana Dave     678901234\n" +
                "3. Uma Jain      987654321\n" +
                "\n" +
                "Visual arts\n" +
                "1. Rahul shah   787919199\n" +
                "2. Raj Jha         728191919";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);

    }
}
