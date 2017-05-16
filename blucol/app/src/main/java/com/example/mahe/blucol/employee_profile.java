package com.example.mahe.blucol;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.UUID;

public class employee_profile extends AppCompatActivity {


    private ProgressDialog mProgressDialog;
    private static final int GALLERY_INTENT = 2;
    private Button mSelectImage;
    private StorageReference mStorage;
    private de.hdodenhof.circleimageview.CircleImageView abc;
    private EditText editText100;

    private TextView textViewNameyes;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String userId;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private TextView textViewContactNoyes;
    private TextView textViewAgeyes;
    private TextView textViewDescriptionyes;
    private TextView textViewLocationyes;
    private TextView textViewGenderyes;

    private ListView mListView;
    private ArrayList<String> mUsernames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);

        Intent intent = getIntent();
        String post = intent.getStringExtra("post");


       mStorage = FirebaseStorage.getInstance().getReference();

        editText100 = (EditText) findViewById(R.id.editText100);

        mSelectImage = (Button) findViewById(R.id.updatepic);


        abc = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.newcircle);


        mProgressDialog = new ProgressDialog(this);

        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);

            }
        });



      mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        if (TextUtils.isEmpty(userId)) {
           userId = mUser.getUid();
        }

        //FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //DatabaseReference mRootReference = firebaseDatabase.getReference();
        //DatabaseReference mHeadingReference = mRootReference.child("worker");
        //DatabaseReference hullo = mHeadingReference.child(work);
        //DatabaseReference god = hullo.child("imageId");


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        DatabaseReference mFirebaseDatabaseChild = null;
        if(post.equals("employee"))
        {mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");}
        else if(post.equals("employer"))
        {mFirebaseDatabaseChild = mFirebaseDatabase.child("employer");}




    DatabaseReference def = mFirebaseDatabaseChild.child(userId);
        DatabaseReference god = def.child("imageId");
        DatabaseReference lip = def.child("reviews");



        god.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {

                String message = dataSnapshot1.getValue(String.class);


                mStorage.child("Photos").child(message).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.with(employee_profile.this).load(uri).fit().centerCrop().into(abc);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });



        // implementing the reviews


        mListView = (ListView) findViewById(R.id.def);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);

        mListView.setAdapter(arrayAdapter);






        lip.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                mUsernames.add(value);
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






        // updating other parameters of the profile




        textViewNameyes = (TextView) findViewById(R.id.textViewName);
        textViewAgeyes = (TextView) findViewById(R.id.textViewAge);
        textViewContactNoyes = (TextView) findViewById(R.id.textViewContactNo);
        textViewGenderyes = (TextView) findViewById(R.id.textViewGender);
        textViewLocationyes = (TextView) findViewById(R.id.textViewLocation);
        textViewDescriptionyes = (TextView) findViewById(R.id.textViewDescription);
        ;

//        DatabaseReference proHeadingReference = mHeadingReference.child(work);
        DatabaseReference furtherHeadingReference = def.child("cn1");
//        DatabaseReference furtherHeadingReference1 = def.child("age");
        DatabaseReference furtherHeadingReference2 =   def.child("address");
        DatabaseReference furtherHeadingReference3 = def.child("sex");
        DatabaseReference furtherHeadingReference4 = def.child("name");
        DatabaseReference furtherHeadingReference5 = def.child("description");



        furtherHeadingReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String message = dataSnapshot.getValue(String.class);
                textViewContactNoyes.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


  /*      furtherHeadingReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {


                String message = dataSnapshot1.getValue(String.class);
                textViewAgeyes.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

       furtherHeadingReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot2) {


                String message = dataSnapshot2.getValue(String.class);
                textViewLocationyes.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        furtherHeadingReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot3) {


                String message = dataSnapshot3.getValue(String.class);

                textViewGenderyes.setText(message);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        furtherHeadingReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot7) {


                String message = dataSnapshot7.getValue(String.class);
                textViewNameyes.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        furtherHeadingReference5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot2) {


                String message = dataSnapshot2.getValue(String.class);
                textViewDescriptionyes.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            mProgressDialog.setMessage("Uploading...");
            mProgressDialog.show();
            Uri uri = data.getData();


            final String uuid = UUID.randomUUID().toString();

            StorageReference filepath = mStorage.child("Photos").child(uuid);
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                    Intent intent = getIntent();
                    String post = intent.getStringExtra("post");


                    mFirebaseInstance = FirebaseDatabase.getInstance();
                    mFirebaseDatabase = mFirebaseInstance.getReference("users");

                    DatabaseReference mFirebaseDatabaseChild = null;
                    if(post.equals("employee"))
                    {mFirebaseDatabaseChild = mFirebaseDatabase.child("employee");}
                    else if(post.equals("employer"))
                    {mFirebaseDatabaseChild = mFirebaseDatabase.child("employer");}


                    DatabaseReference hullo = mFirebaseDatabaseChild.child(userId);
                    DatabaseReference god = hullo.child("imageId");

                    god.setValue(uuid);


                    Toast.makeText(employee_profile.this, "Upload done", Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();


                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    Picasso.with(employee_profile.this).load(downloadUri).fit().into(abc);


                    mProgressDialog.dismiss();


                }
            });


        }


    }


}
