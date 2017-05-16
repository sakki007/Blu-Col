package com.example.mahe.blucol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;


public class LoginActivityEmployer extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button btnLogin;
    private TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employer);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        //***Checks if a user already logged in***//
        /*
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivityEmployer.this, ChosingActivity.class));
            finish();
        }
        */

        // set the view now





        setContentView(R.layout.activity_login_employer);

        inputEmail = (EditText) findViewById(R.id.loginEmailEr);
        inputPassword = (EditText) findViewById(R.id.loginPasswordEr);
        btnLogin = (Button) findViewById(R.id.loginButtonEr);


        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


        //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivityEmployer.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                //progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(LoginActivityEmployer.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {

                                   Intent intent2 = getIntent();
                                    String post = intent2.getStringExtra("post");

                                    Intent intent = new Intent(LoginActivityEmployer.this, employerDashboard2.class);
                                    intent.putExtra("post",post);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }

        });
    }



    public void employerSignup(View view) {

        Intent intent2 = getIntent();
        String post = intent2.getStringExtra("post");

        Intent intent = new Intent(this, SignupActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }


    }


