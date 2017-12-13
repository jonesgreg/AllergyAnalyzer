package com.example.jack.allergyanalyzer;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class RecSearchActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText queryTxt;
    private Button searchButton;
    //check boolean, true get the strings
    public boolean validIngredient;
    //passing through JSON
    public String query;
    private Button voiceSearch;

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
        setContentView(R.layout.activity_rec_search);

        Intent intent = new Intent(this, PersistentDataService.class);

        if (!mBound)
        {
            bindService(intent, mConnection, BIND_AUTO_CREATE);
        }


        this.validIngredient = false;

        queryTxt = (EditText) findViewById(R.id.editTextIngredients);
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
        if(resultCode == RESULT_OK && data != null) { ///Check which request we're responding to
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            queryTxt.setText(result.get(0));
        }
    }

    @Override
    public void onClick(View v)
    {
        if(name != null && allergies != null)
        {
           /* Log.e(" onClick Rec", name);
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
                        "Please enter some recipes",
                        Toast.LENGTH_SHORT).show();
            }*/
           query = queryTxt.getText().toString();
           if(query != "")
           {
               AppState state = AppState.getInstance();
               state.setQuery(query);
               JSONQueryRecipeSearch  startQuery = new JSONQueryRecipeSearch(query, getApplicationContext());
               startQuery.setUrl();
               startQuery.execute();
           }
           else
           {
               Toast.makeText(this, "Please enter some recipes", Toast.LENGTH_SHORT).show();
           }
        }
        else
        {
            Toast.makeText(this, "Please log in before searching!", Toast.LENGTH_LONG).show();
        }

    }
}
