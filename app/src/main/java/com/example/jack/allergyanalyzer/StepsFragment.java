package com.example.jack.allergyanalyzer;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by gregoryjones on 11/24/17.
 */

public class StepsFragment extends Fragment {
    private final String TAG = "Recipe Fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "The " + TAG + " for application has been created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "The " + TAG + " for application has been destroyed");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "The " + TAG + " for application has been paused");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "The " + TAG + " for application has been started");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "The " + TAG + " for application has resumed");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "The " + TAG + " for application has stopped");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        AppState state = AppState.getInstance();
        View view = inflater.inflate(R.layout.fragment_steps, container, false);
        // Inflate the layout for this fragment

        Recipe recipe = null;
        try {
            recipe = state.makeRecipe();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Show ingredients
        String[] steps = new String[0];
        try {
            steps = recipe.getSteps();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListView stepsListView = (ListView)view.findViewById(R.id.stepsListView);
        stepsListView.setBackgroundColor(Color.parseColor("#4846ba"));

        if (steps.length > 0) {
            ArrayAdapter<String> stepsAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    steps);
            stepsListView.setAdapter(stepsAdapter);
        } else {
            ArrayList<String> list = new ArrayList<String>();
            list.add("No steps found, see recipe website");
            ArrayAdapter<String> stepsAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    list);
            stepsListView.setAdapter(stepsAdapter);
        }

        // Deal with the back button

        //Button backButton = (Button)view.findViewById(R.id.backButton);

        return view;
    }

}
