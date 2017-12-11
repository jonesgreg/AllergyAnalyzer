package com.example.jack.allergyanalyzer;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class IngSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextIngredients;
    private Button searchButton;
    private Button voiceSearch;

    //check boolean, true get the strings
    public boolean validIngredient;
    //passing through JSON
    public String ingredientsString;



    String name;
    ArrayList<String> allergies;
    // binds service to activity
    private PersistentDataService mService;
    private boolean mBound = false;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            PersistentDataService.LocalBinder binder = (PersistentDataService.LocalBinder) service;
            mService = binder.getService();
            name = mService.cName;
            allergies = mService.cAllergies;

            mBound = true;
            Log.e("  in onServiceConnected", "conntected!");

        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
            mBound = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing_search);



        Intent intent = new Intent(this, PersistentDataService.class);

        if (!mBound)
        {
            bindService(intent, mConnection, BIND_AUTO_CREATE);
        }


        // readFile();
        this.validIngredient = false;

        editTextIngredients = (EditText) findViewById(R.id.editTextIngredients); //The user's output
        searchButton = (Button) findViewById(R.id.buttonSearch);
        searchButton.setOnClickListener(this);

        voiceSearch = (Button) findViewById(R.id.voiceSearch);
        voiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                try {
                    startActivityForResult(intent, 200);

                }catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "intent problem", Toast.LENGTH_SHORT).show();

                }

            }
        });




    }
    /**
     * Receiving User's results from the google voice API
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            editTextIngredients.setText(result.get(0));
        }
    }

        @Override
        public void onClick (View v) {
            if (name != null && allergies != null) {
                Log.e("  in onClick", name);

                ingredientsString = editTextIngredients.getText().toString();
                if (ingredientsString != "") {
                    //start a new intent to a list
                    AppState state = AppState.getInstance();
                    state.setingredients(ingredientsString);
                    final String[] recipeList = state.getIngredients().split(",");
                    JSONQuery query = new JSONQuery(recipeList, getApplicationContext());
                    query.setUrl();
                    query.execute();
                } else {
                    Toast.makeText(this,
                            "Please enter some ingredients",  //This Allow the user to input an food item
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please log in before searching!", Toast.LENGTH_LONG).show();
            }

        }





}
