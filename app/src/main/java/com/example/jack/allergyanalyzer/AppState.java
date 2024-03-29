package com.example.jack.allergyanalyzer;

import android.app.Application;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by gregoryjones on 11/24/17.
 */

public class AppState extends Application {
    private static final AppState ourInstance = new AppState();
    private static String TAG = "AppState";

    private String query;
    private List<Dish> dishes;
    private int position;
    private JSONArray currentRecipe;

    static AppState getInstance() {
        return ourInstance;
    }

    public AppState() {
        if (getInstance() == null) {
            query = "";
            position = 0;
            currentRecipe = null;
            Log.i(TAG, "Appstate init");
        } else {
            // This shouldn't do anything
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String list) {query = list;}

    public void setDishes(List<Dish> list) {
        dishes = list;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setCurrentRecipe(JSONArray arr) {
        currentRecipe = arr;
    }

    public Recipe makeRecipe() throws JSONException {
        JSONObject object = currentRecipe.getJSONObject(0);
        String title = object.getString("title");
        int minutes = object.getInt("readyInMinutes");
        int id = object.getInt("id");
        JSONArray ingredients = object.getJSONArray("extendedIngredients");
        String url = object.getString("sourceUrl");
        JSONArray steps = object.getJSONArray("analyzedInstructions");
        Recipe recipe = new Recipe(title,id,minutes,url,ingredients, steps);
        return recipe;
    }



}
