package com.example.mahe.blucol;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class employerDashboard2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<String> jobid = new ArrayList<>();
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;
    private TextView textView;
    private FloatingActionButton fab_1,fab_2,fab_3;
    Animation FabOpen, FabClose;
    boolean isOpen = false;
    private EditText edi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_dashboard2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        edi = (EditText) findViewById(R.id.textViewslb18);

        edi.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

        textView = (TextView) findViewById(R.id.textViewsatan);

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        // userId = mUser.getUid();
        if (TextUtils.isEmpty(userId))
        {  userId = mUser.getUid();
        }

        mFirebaseInstance = FirebaseDatabase.getInstance();

        DatabaseReference heyt = mFirebaseInstance.getReference("users");
        DatabaseReference yupt = heyt.child("employer").child(userId).child("name");



        yupt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {


                String message = dataSnapshot1.getValue(String.class);
                textView.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






        fab_1 = (FloatingActionButton) findViewById(R.id.but1);
        fab_2 = (FloatingActionButton) findViewById(R.id.but2);
        fab_3 = (FloatingActionButton) findViewById(R.id.but3);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);


        fab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(isOpen)
                {
                    fab_2.startAnimation(FabClose);
                    fab_3.startAnimation(FabClose);
                    fab_2.setClickable(false);
                    fab_3.setClickable(false);

                    isOpen = false;
                }
                else
                {
                    fab_2.startAnimation(FabOpen);
                    fab_3.startAnimation(FabOpen);
                    fab_2.setClickable(true);
                    fab_3.setClickable(true);

                    isOpen = true;

                }
            }
        });






        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jobid);



        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        // userId = mUser.getUid();
        if (TextUtils.isEmpty(userId))
        {  userId = mUser.getUid();
        }

        mFirebaseInstance = FirebaseDatabase.getInstance();

        DatabaseReference hey = mFirebaseInstance.getReference("users");
        DatabaseReference yup = hey.child("employer").child(userId).child("jobsPosted");


        yup.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                jobid.add(value);
                arrayAdapter.notifyDataSetChanged();
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










    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.employer_dashboard2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.employerprofile2) {
            Intent intent19 = new Intent(this,employee_profile.class);
            intent19.putExtra("post","employer");
            startActivity(intent19);
        }



        if (id == R.id.jobupload) {
            Intent intent19 = new Intent(this,jobpost.class);
            startActivity(intent19);
        }

        if (id == R.id.jobemployeesearch) {


        if(jobid.size()>=1) {
            Intent intent32 = new Intent(this, jobemployeesearch.class);
            intent32.putExtra("jobids", jobid);
            startActivity(intent32);
        }

        }

        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

public void profileclick(View view)
{
    Intent intent19 = new Intent(this,employee_profile.class);
    intent19.putExtra("post","employer");
    startActivity(intent19);
}

    public void addjobclick(View view)
    {
        Intent intent19 = new Intent(this,jobpost.class);
        startActivity(intent19);
    }

    public void jobviewclick(View view) throws InterruptedException {

        if(jobid.size()>=1) {
            Intent intent32 = new Intent(this, jobemployeesearch.class);
            intent32.putExtra("jobids", jobid);
            startActivity(intent32);
        }
    }


    public void aboutclick(View view)
    {
        Intent intent56 = new Intent(this,about.class);
        startActivity(intent56);
    }

}

