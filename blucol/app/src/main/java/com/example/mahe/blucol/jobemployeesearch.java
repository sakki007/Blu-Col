package com.example.mahe.blucol;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
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
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

    public class jobemployeesearch extends AppCompatActivity implements GestureDetector.OnGestureListener {

        int q = 0;
        int t;

        int s = 0;

        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;
        private TextView textView5;
        private GestureDetectorCompat detector;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_jobemployeesearch);

            textView1 = (TextView) findViewById(R.id.textView1199);
            textView2 = (TextView) findViewById(R.id.textView1799);
            textView3 = (TextView) findViewById(R.id.textView1899);
            textView4 = (TextView) findViewById(R.id.textView2899);
            textView5 = (TextView) findViewById(R.id.textView3199);


            Intent intent9 = getIntent();
            ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");

            t = mUsernames.size();


            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


            DatabaseReference booh = firebaseDatabase.getReference("jobdescription");


            //       String ttt = String.valueOf(mUsernames.size());
            //      textView5.setText(ttt);
            //     textView4.setText("aaa");

            t = mUsernames.size();


            String nah = mUsernames.get(q);


            DatabaseReference val1 = booh.child(nah);

            DatabaseReference val2 = val1.child("employerId");
            DatabaseReference val3 = val1.child("location");
            DatabaseReference val4 = val1.child("date");
            DatabaseReference val5 = val1.child("wage");


            DatabaseReference val6 = val1.child("description");

            val6.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView5.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView1.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView2.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView3.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView4.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            //swipe implementation

            detector = new GestureDetectorCompat(this, (GestureDetector.OnGestureListener) this);


        }


        public void next(View view)

        {
            q++;
            if (q == t) {
                q = 0;
            }


            Intent intent9 = getIntent();
            ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");

            String nah = mUsernames.get(q);

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference booh = firebaseDatabase.getReference("jobdescription");

            DatabaseReference val1 = booh.child(nah);

            DatabaseReference val2 = val1.child("employerId");
            DatabaseReference val3 = val1.child("location");
            DatabaseReference val4 = val1.child("date");
            DatabaseReference val5 = val1.child("wage");


            DatabaseReference val6 = val1.child("description");

            val6.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView5.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView1.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView2.setText(message);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView3.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView4.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


        }


        public void previous(View view)

        {

            if (q == 0)
                q = t;

            q--;


            Intent intent9 = getIntent();
            ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");


            String nah = mUsernames.get(q);

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference booh = firebaseDatabase.getReference("jobdescription");

            DatabaseReference val1 = booh.child(nah);

            DatabaseReference val2 = val1.child("employerId");
            DatabaseReference val3 = val1.child("location");
            DatabaseReference val4 = val1.child("date");
            DatabaseReference val5 = val1.child("wage");


            DatabaseReference val6 = val1.child("description");

            val6.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView5.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView1.setText((message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView2.setText(message);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            val4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView3.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            val5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    String message = dataSnapshot.getValue(String.class);
                    textView4.setText(String.valueOf(message));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


        }


        public void onSelect(View view) {


            Intent intent9 = getIntent();
            ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");


            String jobExtra = mUsernames.get(q);

            Intent intent10 = new Intent(this, job_select.class);
            intent10.putExtra("jobId", jobExtra);
            startActivity(intent10);
        }


        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float x1, x2, value = 0;
            x1 = e1.getX();
            x2 = e2.getX();
            value = x1 - x2;

            if (value > 200) {
                s++;
                //left


                if (q == 0)
                    q = t;

                q--;


                Intent intent9 = getIntent();
                ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");

                String nah = mUsernames.get(q);

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference booh = firebaseDatabase.getReference("jobdescription");

                DatabaseReference val1 = booh.child(nah);

                DatabaseReference val2 = val1.child("employerId");
                DatabaseReference val3 = val1.child("location");
                DatabaseReference val4 = val1.child("date");
                DatabaseReference val5 = val1.child("wage");


                DatabaseReference val6 = val1.child("description");

                val6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView5.setText((message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView1.setText((message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView2.setText(message);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView3.setText(String.valueOf(message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });


                val5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView4.setText(String.valueOf(message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });


            } else if (value < 200) {//right


                q++;
                if (q == t) {
                    q = 0;
                }


                Intent intent9 = getIntent();
                ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");

                String nah = mUsernames.get(q);

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference booh = firebaseDatabase.getReference("jobdescription");

                DatabaseReference val1 = booh.child(nah);

                DatabaseReference val2 = val1.child("employerId");
                DatabaseReference val3 = val1.child("location");
                DatabaseReference val4 = val1.child("date");
                DatabaseReference val5 = val1.child("wage");


                DatabaseReference val6 = val1.child("description");

                val6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView5.setText((message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView1.setText((message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView2.setText(message);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView3.setText(String.valueOf(message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                val5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        String message = dataSnapshot.getValue(String.class);
                        textView4.setText(String.valueOf(message));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });


            }
            return true;
        }

        public boolean onTouchEvent(MotionEvent event) {
            detector.onTouchEvent(event);
            return super.onTouchEvent(event);
        }


        public void appliedWorkers(View view)
        {

            Intent intent9 = getIntent();
            ArrayList<String> mUsernames = intent9.getStringArrayListExtra("jobids");

            String nah = mUsernames.get(q);


            Intent intent69 = new Intent(this,jobemployeesearchfurther.class);
            intent69.putExtra("jobid",nah);
            startActivity(intent69);
        }
    }


