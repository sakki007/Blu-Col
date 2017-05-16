package com.example.mahe.blucol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivityEmployee extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        //***Checks if a user already logged in***//

        /*if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivityEmployee.this, ChosingActivity.class));
            finish();
        }*/

        // set the view now
        setContentView(R.layout.activity_login_employee);

        inputEmail = (EditText) findViewById(R.id.loginEmailEe);
        inputPassword = (EditText) findViewById(R.id.loginPasswordEe);
        btnLogin = (Button) findViewById(R.id.loginButtonEe);

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
                        .addOnCompleteListener(LoginActivityEmployee.this, new OnCompleteListener<AuthResult>() {
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
                                        Toast.makeText(LoginActivityEmployee.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {


                                        Intent intent = new Intent(LoginActivityEmployee.this, dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }

        });
    }
    public void employeeSignup(View view) {



        Intent intent=new Intent(this,SignupActivity.class);
        intent.putExtra("post","employee");
        startActivity(intent);
    }
}