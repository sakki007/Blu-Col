package com.example.mahe.blucol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class employeeDescription extends AppCompatActivity {


    private EditText des;
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_description);

        des = (EditText) findViewById(R.id.editdesc);

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        if (TextUtils.isEmpty(userId)) {
            userId = mUser.getUid();
        }


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");
        DatabaseReference hullo = mFirebaseDatabaseChild.child(userId);
        DatabaseReference god = hullo.child("description");

        god.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                des.setText(message);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }





    public void descriptionadd(View view)
    {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");
        DatabaseReference hullo = mFirebaseDatabaseChild.child(userId);
        DatabaseReference god = hullo.child("description");

        String description = des.getText().toString();
        god.setValue(description);
    }
}
