package com.example.mahe.blucol;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class about extends AppCompatActivity {


    private de.hdodenhof.circleimageview.CircleImageView abcanchit;
    private de.hdodenhof.circleimageview.CircleImageView abcsaksham;
    private de.hdodenhof.circleimageview.CircleImageView abcmoinak;
    private TextView textView1999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);



        abcanchit = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.updatepicanchit);
        abcsaksham = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.updatepicsaksham);
        abcmoinak = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.updatepicmoinak);

        abcanchit.setImageResource(R.drawable.updatepicanchit);
        abcsaksham.setImageResource(R.drawable.updatepicsaksham);
        abcmoinak.setImageResource(R.drawable.updatepicmoinak);



    }


    public void emailclick(View view)
    {
        Log.i("Send email", "");
        String[] TO = {"blucol.team@gmail.com"};
        String[] CC = {};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(about.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
