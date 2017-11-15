package com.example.jack.allergyanalyzer;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by gregoryjones on 11/13/17.
 */

public class AppState {
    private static final AppState ourInstance = new AppState();
    private static String TAG = "com.example.gregoryjones.ingredientsandrecipes.AppState";

    private String ingredientString;
    private List<Dish> dishes;
    private int position;
    private JSONArray currentRecipe;

    static AppState getInstance() {
        return ourInstance;
    }

    public AppState() {
        if (getInstance() == null) {
            ingredientString = "";
            position = 0;
            currentRecipe = null;
            Log.i(TAG, "Appstate init");
        } else {
            // This shouldn't do anything
        }
    }

    public String getIngredients() {
        return ingredientString;
    }

    public void setingredients(String list) {
        ingredientString = list;
    }

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

