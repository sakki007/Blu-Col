package com.example.mahe.blucol;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.*;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static android.text.TextUtils.isDigitsOnly;

public class UserProfile extends AppCompatActivity {

    private TextView txtDetails;
    private EditText inputName, inputAddress,inputContact1,inputContact2;
    private RadioButton inputMale,inputFemale;
    private Button btnSubmit;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);






        inputName = (EditText) findViewById(R.id.name);
        inputAddress = (EditText) findViewById(R.id.address);
        inputContact1 = (EditText) findViewById(R.id.contact1);
        inputContact2 = (EditText) findViewById(R.id.contact2);
        inputMale =(RadioButton) findViewById(R.id.radioMale);
        inputFemale=(RadioButton) findViewById(R.id.radioFemale);
        btnSubmit = (Button) findViewById(R.id.submit);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node

        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String address = inputAddress.getText().toString();
                String contact1 = inputContact1.getText().toString();
                String contact2 = inputContact2.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(getApplicationContext(), "Enter Address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contact1)) {
                    Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contact1.length()<10||contact1.length()>10) {
                    Toast.makeText(getApplicationContext(), "Invalid contact number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contact2.length()<10||contact2.length()>10) {
                    Toast.makeText(getApplicationContext(), "Invalid alternate contact number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!TextUtils.isDigitsOnly(contact1))
                {
                    Toast.makeText(getApplicationContext(), "Invalid contact number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!TextUtils.isDigitsOnly(contact2))
                {
                    Toast.makeText(getApplicationContext(), "Invalid alternate contact number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sex;
                if(inputMale.isChecked())
                    sex="Male";
                else if(inputFemale.isChecked())
                    sex="Female";
                else
                    sex="NA";
                //mUser=firebaseAuth.getCurrentUser();
                //userId = mUser.getUid();
                // Check for already existed userId
          //          createUser(name, address,contact1,contact2,sex);
//                Intent intent=new Intent(UserProfile.this,ChosingActivity.class);
  //              startActivity(intent);


                if (TextUtils.isEmpty(userId))

                {

                    mAuth=FirebaseAuth.getInstance();
                   mUser=mAuth.getCurrentUser();
                // userId = mUser.getUid();
                if (TextUtils.isEmpty(userId))
                   {  userId = mUser.getUid();
                   }

                User_Database user = new User_Database(name, address,contact1,contact2,sex);




                Intent intent2 = getIntent();
                String post = intent2.getStringExtra("post");

                if(post.equals("employee"))
                {DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");
                    mFirebaseDatabaseChild.child(userId).setValue(user);
                  //  mFirebaseDatabaseChild.child(userId).child("imageId").setValue("b25fd398-d0b6-4e49-97d4-642779179fd0");


                    Intent intent9 = new Intent(UserProfile.this, dashboard.class);
                    intent9.putExtra("post",post);
                    startActivity(intent9);
                }

                else if(post.equals("employer"))

                {
                    DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employer");
                    mFirebaseDatabaseChild.child(userId).setValue(user);}

                    Intent intent10 = new Intent(UserProfile.this,employerDashboard2.class);
                    intent10.putExtra("post",post);
                    startActivity(intent10);


            }


            }
        });}


    /*
    private void createUser(String name, String address,String contact1,String contact2,String sex) {
        mAuth=FirebaseAuth.getInstance();
       mUser=mAuth.getCurrentUser();
       // userId = mUser.getUid();
        if (TextUtils.isEmpty(userId)) {
             userId = mUser.getUid();
        }

        User_Database user = new User_Database(name, address,contact1,contact2,sex);




        Intent intent2 = getIntent();
        String post = intent2.getStringExtra("post");

        if(post.equals("employee"))
        {DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");
        mFirebaseDatabaseChild.child(userId).setValue(user);


            Intent intent9 = new Intent(UserProfile.this, dashboard.class);
            intent2.putExtra("useful",post);
            startActivity(intent9);
        }

       else if(post.equals("employer"))

        {
        DatabaseReference mFirebaseDatabaseChild = mFirebaseDatabase.child("employer");
        mFirebaseDatabaseChild.child(userId).setValue(user);}


    }
*/
    /**
     * User data change listener
     */

}
