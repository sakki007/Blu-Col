package com.example.mahe.blucol;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jobemployeesearchfurther extends AppCompatActivity {


    private ListView listview9;
    private ArrayList<String> mUsernames = new ArrayList<>();
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;
    String[] jobs = new String[]{};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobemployeesearchfurther);


        listview9 = (ListView) findViewById(R.id.lst);

        Intent intent = getIntent();
        String jobId = intent.getStringExtra("jobid");












        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mRootReference = firebaseDatabase.getReference("jobdescription");

         DatabaseReference yup = mRootReference.child(jobId).child("applied");




        yup.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                mUsernames.add(value);
                arrayAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        int total_length = mUsernames.size();


        final List<String> jobs_list = new ArrayList<String>(Arrays.asList(jobs));

        final ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jobs_list);

/*
        for(int i=0;i<total_length;i++)
        {
            DatabaseReference mRootReference1 = firebaseDatabase.getReference("users");

            DatabaseReference yup1 = mRootReference1.child("employee").child(mUsernames.get(i)).child("name");

            yup1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot7) {

                    String message = dataSnapshot7.getValue(String.class);
                    if(message!=null)
                        jobs_list.add(message);

                    arrayAdapter7.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }
*/








     /*   jobs_list.add("hey");
        jobs_list.add("toto");
        jobs_list.add("mayo");
        jobs_list.add("goto");
        jobs_list.add(String.valueOf(total_length));
        jobs_list.add(jobId);*/







        final ArrayAdapter<String> adapter80 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,jobs);
        listview9.setAdapter(adapter80);

        listview9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = ((TextView)view).getText().toString();

                int pos = parent.getPositionForView(view);
                String lola = mUsernames.get(pos);
               Intent intent1001 = new Intent(getApplicationContext(),profileselect.class);
                intent1001.putExtra("use",lola);
                intent1001.putExtra("post","employee");
                startActivity(intent1001);
            }
        });



    }



    public void but(View view)
    {

        int total_length = mUsernames.size();



        final List<String> jobs_list = new ArrayList<String>(Arrays.asList(jobs));

        final ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jobs_list);

        listview9.setAdapter(arrayAdapter7);

        Intent intent = getIntent();
        String jobId = intent.getStringExtra("jobid");




//        jobs_list.add("hey");
  //      jobs_list.add("toto");
    //    jobs_list.add("mayo");
      //  jobs_list.add("goto");
      //  jobs_list.add(String.valueOf(total_length));
       // jobs_list.add(jobId);

        if (TextUtils.isEmpty(userId))

        {

            mAuth = FirebaseAuth.getInstance();
            mUser = mAuth.getCurrentUser();
            // userId = mUser.getUid();
            if (TextUtils.isEmpty(userId)) {
                userId = mUser.getUid();
            }
        }



    if(total_length!=0) {
        FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
        DatabaseReference booh = firebaseDatabase1.getReference("users");

        for (int i = 0; i < total_length; i++) {
            DatabaseReference val1 = booh.child("employee").child(mUsernames.get(i)).child("name");

            val1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    jobs_list.add(message);
                    arrayAdapter7.notifyDataSetChanged();


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    else if (total_length==0)
    {
        jobs_list.add("No one has applied for the jobs yet");
        arrayAdapter7.notifyDataSetChanged();
    }




        arrayAdapter7.notifyDataSetChanged();


    }
}
