package com.example.mahe.blucol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class jobpost extends AppCompatActivity {


    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;
    private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobpost);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);


    }



    public void onPost(View view)
    {
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        // userId = mUser.getUid();
        if (TextUtils.isEmpty(userId))
        {  userId = mUser.getUid();
        }


        mFirebaseInstance = FirebaseDatabase.getInstance();

        DatabaseReference hey = mFirebaseInstance.getReference("jobs");
        DatabaseReference desc = mFirebaseInstance.getReference("jobdescription");

        DatabaseReference sup = mFirebaseInstance.getReference("users");
        DatabaseReference rup = sup.child("employer");
        DatabaseReference hum = rup.child(userId);
        DatabaseReference tow = hum.child("jobsPosted");

        String sector = e5.getText().toString();
        String jobdescription = e1.getText().toString();
        String wage = e2.getText().toString();
        String date = e3.getText().toString();
        String location = e4.getText().toString();




        DatabaseReference toy = hey.child(sector);

        final String uuid = UUID.randomUUID().toString();
        final String uuid2 = UUID.randomUUID().toString();


        DatabaseReference yes = toy.child(uuid2);
        yes.setValue(uuid);

        DatabaseReference nope = desc.child(uuid);
        nope.child("description").setValue(jobdescription);
        nope.child("wage").setValue(wage);
        nope.child("date").setValue(date);
        nope.child("location").setValue(location);
        nope.child("employerId").setValue(userId);

        String id1 = tow.push().getKey();
        tow.child(id1).setValue(uuid);



    }
}
