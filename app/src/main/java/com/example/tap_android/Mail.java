package com.example.tap_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mail extends AppCompatActivity {

    Button send;
    EditText subject,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        subject=findViewById(R.id.subject);
        message=findViewById(R.id.message);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                sendEmail();
            }
        });
    }


    void sendEmail() {
        String msubject=subject.getText().toString();
        String mcon=message.getText().toString();
        Log.i("Send email", "DEKH");
        String[] TO = {"rrpatanwadia@ymail.com"};
        String[] CC = {"rajshah2320@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, msubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mcon);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            //  Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}

