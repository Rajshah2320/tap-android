package com.example.tap_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tap_Home extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ListView listView;
    ArrayList<String> name,uids;
    static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap__home);

        listView=findViewById(R.id.listView);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users");
        //need to be changed to users
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name=new ArrayList<>();
                uids=new ArrayList<>();

                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
                    uids.add(0, childSnapshot.getKey());
                    name.add(0, childSnapshot.child("name").getValue(String.class));
                    System.out.println();
                }
                CustomAdapter customAdapter=new CustomAdapter(Tap_Home.this,uids,name);
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(Tap_Home.this,QuestionsVolunteer.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

    }
}
