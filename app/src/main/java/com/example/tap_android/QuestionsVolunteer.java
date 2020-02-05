package com.example.tap_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionsVolunteer extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> a1,a2,a3,a4,email;
    TextView A1,A2,A3,A4;
    Button btnAccept,btnReject;
    static String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_volunteer);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users");
        A1=findViewById(R.id.answer_tv);
        A2=findViewById(R.id.answer2_tv);
        A3=findViewById(R.id.answer3_tv);
        A4=findViewById(R.id.answer4_tv);
        btnAccept = findViewById(R.id.btnAccept);
        btnReject = findViewById(R.id.btnReject);
        Intent intent=getIntent();
        final int pos=intent.getIntExtra("position",0);

        final String mailSub = "Result for your TAP application.";

        final String rejectText = "Dear Participant, \n" +
                "                 We're very sorry but we could not promote you to the next round of selection. We are grateful for your drive and hope that you will try again next year. We hope to see you around!";

        final String acceptText = "Dear participant,                                             \n" +
                "\n" +
                "CONGRATULATIONS! \n" +
                "                  You've cleared the volunteer filtration round two  and you're very close to learn what you love to teach it.  Please select a time slot for our last filtration round. We hope to see you around and would love to have you as a member of the apprentice family !";

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send email", "DEKH");
                String[] TO = {mail};
                Log.i("kaise ho", mail);
                //String CC = "rajshah2320@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                //emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailSub);
                emailIntent.putExtra(Intent.EXTRA_TEXT, acceptText);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    //  Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(QuestionsVolunteer.this, "No mail client installed!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send email", "DEKH");
                String[] TO = {mail};
                Log.i("kaise ho", mail);
                //String CC = "rajshah2320@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                //emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailSub);
                emailIntent.putExtra(Intent.EXTRA_TEXT, rejectText);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    //  Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(QuestionsVolunteer.this, "No mail client installed!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a1=new ArrayList<>();
                a2=new ArrayList<>();
                a3=new ArrayList<>();
                a4=new ArrayList<>();
                email=new ArrayList<>();
                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
                    a1.add(0, childSnapshot.child("motivation").getValue(String.class));
                    a2.add(0, childSnapshot.child("exp").getValue(String.class));
                    a3.add(0, childSnapshot.child("time").getValue(String.class));
                    a4.add(0, childSnapshot.child("message").getValue(String.class));
                    email.add(0, childSnapshot.child("email").getValue(String.class));

                }

                A1.setText(a1.get(pos));
                A2.setText(a2.get(pos));
                A3.setText(a3.get(pos));
                A4.setText(a4.get(pos));
                mail=email.get(pos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
