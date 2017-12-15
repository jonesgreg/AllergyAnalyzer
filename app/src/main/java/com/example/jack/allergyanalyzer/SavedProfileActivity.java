package com.example.jack.allergyanalyzer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SavedProfileActivity extends AppCompatActivity {

    private PersistentDataService mService;
    private boolean mBound = false;

    String name;
    String email;
    boolean gender;
    ArrayList<String> allergies;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            PersistentDataService.LocalBinder binder = (PersistentDataService.LocalBinder) service;
            mService = binder.getService();
            name = mService.cName;
            email = mService.cEmail;
            gender = mService.cGend;
            allergies = mService.cAllergies;

            mBound = true;

            init();

        }
        public void onServiceDisconnected(ComponentName className) {
            mService = null;
            mBound = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_profile);

        Intent intent = new Intent(this, PersistentDataService.class);


        if (!mBound && name == null)
        {
            bindService(intent, mConnection, BIND_IMPORTANT);
        }
        else
        {
            Toast.makeText(SavedProfileActivity.this, "Must login before viewing profile",
                    Toast.LENGTH_LONG).show();
        }

        Log.e("     In On Create", "first checkpoint reached");


    }


    protected void init()
    {
        TextView userNameView = (TextView)findViewById(R.id.textView7);
        TextView emailView    = (TextView)findViewById(R.id.textView14);
        TextView genderView   = (TextView)findViewById(R.id.textView16);
        TextView allergyView  = (TextView)findViewById(R.id.scrollingText);
        allergyView.setSelected(true);

        if (name != null) {
            userNameView.setText(name);

            emailView.setText(email);

            if (gender) {
                genderView.setText("Male");
            }
            else {
                genderView.setText("Female");
            }

            String[] a = new String[allergies.size()];
            for (int i = 0; i < allergies.size(); ++i) {
                a[i] = allergies.get(i);
            }

            StringBuilder sb = new StringBuilder();
            for (String i : allergies) {
                sb.append(i + ", ");
            }
            allergyView.setText(sb.toString());
        }

    }
}
