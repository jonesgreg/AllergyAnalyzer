package com.example.jack.allergyanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.jack.allergyanalyzer.R;
import com.example.jack.allergyanalyzer.SavedProfilePage;

public class ProfilePage extends AppCompatActivity {
    public static final String SAVED_NAME = "com.allergyanalyzer.allergyanalyzer.nameMessage";
    public static final String SAVED_PHONE = "com.allergyanalyzer.allergyanalyzer.phoneMessage";
    public static final String SAVED_EMAIL = "com.allergyanalyzer.allergyanalyzer.emailMessage";
    public static final String SAVED_ALLERGY = "com.allergyanalyzer.allergyanalyzer.allergyMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }

    /** Called when the user taps the Save button */
    public void saveMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(ProfilePage.this, SavedProfilePage.class);
        Bundle extras = new Bundle();
        //Takes in person's name
        EditText editText = findViewById(R.id.editText5);
        String nameMessage = editText.getText().toString();
        extras.putString(SAVED_NAME, nameMessage);

        //Takes in person's phone number
        editText = findViewById(R.id.editText6);
        String phoneMessage = editText.getText().toString();
        extras.putString(SAVED_PHONE, phoneMessage);

        //Takes in person's email
        editText = findViewById(R.id.editText7);
        String emailMessage = editText.getText().toString();
        extras.putString(SAVED_EMAIL, emailMessage);

        //Take's in person's allergies
        //Batool will change this
        editText = findViewById(R.id.editText9);
        String allergyMessage = editText.getText().toString();
        extras.putString(SAVED_ALLERGY, allergyMessage);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
