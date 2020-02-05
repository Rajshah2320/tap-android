package com.example.tap_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionsVolunteer extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> a1,a2,a3,a4;
    TextView A1,A2,A3,A4;

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
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a1=new ArrayList<>();
                a2=new ArrayList<>();
                a3=new ArrayList<>();
                a4=new ArrayList<>();
                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
                    a1.add(0, childSnapshot.child("motivation").getValue(String.class));
                    a2.add(0, childSnapshot.child("exp").getValue(String.class));
                    a3.add(0, childSnapshot.child("time").getValue(String.class));
                    a4.add(0, childSnapshot.child("message").getValue(String.class));

                }
                Intent intent=getIntent();
                int pos=intent.getIntExtra("position",0);
                A1.setText(a1.get(pos));
                A2.setText(a2.get(pos));
                A3.setText(a3.get(pos));
                A4.setText(a4.get(pos));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
