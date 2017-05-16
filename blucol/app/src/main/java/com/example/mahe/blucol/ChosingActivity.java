package com.example.mahe.blucol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChosingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosing);

    }

      public void employerLogin(View view) {
        Intent intent = new Intent(this,LoginActivityEmployer.class);
            String abc = "employer";
            intent.putExtra("post",abc);
        startActivity(intent);
    }

    public void employeeLogin(View view) {
        Intent intent = new Intent(this,LoginActivityEmployee.class);
        String abc = "employee";
        intent.putExtra("post",abc);
        startActivity(intent);
    }
}
