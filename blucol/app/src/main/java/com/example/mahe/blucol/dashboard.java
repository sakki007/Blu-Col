package com.example.mahe.blucol;

import android.content.Intent;
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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);







        textView = (TextView) findViewById(R.id.textViewsatan);



        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        // userId = mUser.getUid();
        if (TextUtils.isEmpty(userId))
        {  userId = mUser.getUid();
        }

        mFirebaseInstance = FirebaseDatabase.getInstance();

        DatabaseReference heyt = mFirebaseInstance.getReference("users");
        DatabaseReference yupt = heyt.child("employee").child(userId).child("name");



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
        getMenuInflater().inflate(R.menu.dashboard, menu);
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

        if (id == R.id.profile)
        {

            String post = "employee";

            Intent intent100 = new Intent(this,employee_profile.class);
            intent100.putExtra("post",post);
            startActivity(intent100);

        }


        if (id == R.id.accountSettings)
        {
/*
            Intent intent = getIntent();
            String work = intent.getStringExtra("workerId");

            Intent intent100 = new Intent(this,accountInformation.class);
            intent100.putExtra("workerIdForAccountInfo",work);
            startActivity(intent100);
            */
        }

        if (id == R.id.employeeDescription)
        {

            Intent intent = getIntent();
            String work = intent.getStringExtra("workerId");

            Intent intent100 = new Intent(this,employeeDescription.class);
            intent100.putExtra("workerIdForAccountInfo",work);
            startActivity(intent100);

        }
        else if (id == R.id.jobsearch)
        {

            Intent intent = getIntent();
            String work = intent.getStringExtra("workerId");

            Intent intent100 = new Intent(this,employeejobdash.class);
            intent100.putExtra("jobsector","construction");
            startActivity(intent100);

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
        intent19.putExtra("post","employee");
        startActivity(intent19);
    }

    public void searchjobclick(View view)
    {
        // copy the necessary code
    }

    public void accountsettingclick(View view)
    {
        Intent intent19 = new Intent(this,UserProfile.class);
        intent19.putExtra("post","employee");
        startActivity(intent19);
    }

    public void aboutclick(View view)
    {
        Intent intent56 = new Intent(this,about.class);
        startActivity(intent56);
    }

}
