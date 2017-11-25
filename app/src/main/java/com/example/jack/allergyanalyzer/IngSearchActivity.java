package com.example.jack.allergyanalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextIngredients;
    private Button searchButton;
    //check boolean, true get the strings
    public boolean validIngredient;
    //passing through JSON
    public String ingredientsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing_search);
        // readFile();
        this.validIngredient = false;

        editTextIngredients = (EditText) findViewById(R.id.editTextIngredients); //The user's output
        searchButton = (Button) findViewById(R.id.buttonSearch);

        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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

    }

    }

