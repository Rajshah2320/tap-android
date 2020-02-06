package com.example.tap_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CallActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ListView listView;
    ArrayList<String> name,uids,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        listView=findViewById(R.id.selected_listView);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users");
        Intent intent=getIntent();
        final int pos=intent.getIntExtra("position",0);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                uids=new ArrayList<>();
                name=new ArrayList<>();
                phone=new ArrayList<>();
                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){

                    uids.add(0, childSnapshot.getKey());
                    if(childSnapshot.child("selection").getValue(Boolean.class)) {
                        System.out.println( childSnapshot.child("name").getValue(String.class));
                        name.add(0, childSnapshot.child("name").getValue(String.class));
                        phone.add(0,childSnapshot.child("phone").getValue(String.class));
                    }
                }
                CustomAdapter customAdapter=new CustomAdapter(CallActivity.this,uids,name);
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone.get(i).toString()));
                startActivity(intent);
            }
        });
    }
}
