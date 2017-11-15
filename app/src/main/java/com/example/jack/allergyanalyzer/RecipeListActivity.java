package com.example.jack.allergyanalyzer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by gregoryjones on 11/13/17.
 */

public class RecipeListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Log.i(TAG, "Create list from input");

        // Get the list (String or JSON?)
        AppState state = AppState.getInstance();
        List<Dish> dishes = state.getDishes();
        String[] titles = new String[dishes.size()];
        for (int i = 0; i < dishes.size(); ++i) {
            titles[i] = dishes.get(i).getTitle();
        }

        // Set the listview to display all questions
        ListView listView = (ListView)findViewById(R.id.recipeListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                titles);

        listView.setAdapter(adapter);

        // Set the onclick function of each item to go to the quiz activity while passing in
        // selection data
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "List View on Click Pressed. Loading description for " + position);
                Intent intent = new Intent(getApplicationContext(), RecipeFragmentFrame.class);
                AppState.getInstance().setPosition(position);
                startActivity(intent);
            }



        });
    }




}

