package com.example.mahe.blucol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class job_select extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_select);


        Intent intent = getIntent();
        String jobId = intent.getStringExtra("jobId");


    }


    public void apply(View view) {
        Intent intent = getIntent();
        String jobId = intent.getStringExtra("jobId");


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference booh = firebaseDatabase.getReference("jobdescription");
        DatabaseReference hey = booh.child(jobId);
        DatabaseReference top = hey.child("applied");

        String id = hey.push().getKey();

        if (TextUtils.isEmpty(userId))

        {

            mAuth = FirebaseAuth.getInstance();
            mUser = mAuth.getCurrentUser();
            // userId = mUser.getUid();
            if (TextUtils.isEmpty(userId)) {
                userId = mUser.getUid();
            }

            top.child(id).setValue(userId);
            this.finish();
        }

    }
}
