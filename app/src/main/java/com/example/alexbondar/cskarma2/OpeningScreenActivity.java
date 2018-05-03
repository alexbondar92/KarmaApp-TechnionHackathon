package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class OpeningScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);
    }

    public void goToOrganization(View view) {
        Intent intent = new Intent(getApplicationContext(),UserLoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToUser(View view) {
        //ImageButton answerTextView = (ImageButton)findViewById(R.id.organization);
        Intent intent = new Intent(getApplicationContext(),UserLoginActivity.class);
        startActivity(intent);
        finish();
    }
}
