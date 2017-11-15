package com.allergyanalyzer.allergyanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SavedProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_profile_page);

        Bundle extras = getIntent().getExtras();
        String nameMessage = extras.getString(ProfilePage.SAVED_NAME);
        String phoneMessage = extras.getString(ProfilePage.SAVED_PHONE);
        String emailMessage = extras.getString(ProfilePage.SAVED_EMAIL);
        String allergyMessage = extras.getString(ProfilePage.SAVED_ALLERGY);

        TextView textView = findViewById(R.id.textView14);
        textView.setText(nameMessage);


        TextView textView2 = findViewById(R.id.textView17);
        textView2.setText(phoneMessage);

        TextView textView3 = findViewById(R.id.textView18);
        textView3.setText(emailMessage);

        TextView textView4 = findViewById(R.id.textView19);
        textView4.setText(allergyMessage);
    }
}
