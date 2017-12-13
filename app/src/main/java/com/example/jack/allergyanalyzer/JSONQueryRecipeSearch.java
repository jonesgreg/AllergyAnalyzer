package com.example.jack.allergyanalyzer;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 12/13/2017.
 */

public class JSONQueryRecipeSearch extends AsyncTask
{
    private String query;
    private String url;
    private ArrayList<Dish> dishes;
    private Context context;
    private JSONArray jsonArray;

    public JSONQueryRecipeSearch (String q, Context c){
        Log.d("Constructor", "in here!");
        this.query = q;
        this.url = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/search?number=10&offset=0&query=";
        this.dishes = new ArrayList<Dish>(10);
        this.context = c;
    }
    public void setUrl()
    {
        this.url+=this.query;
    }
    public List<Dish> getDishes(){
        return this.dishes;
    }

    public void addDishes() throws JSONException
    {
        Log.d("TAG", "inside add dishes");
        /*for(int i = 0; i < 5; i++) {
            JSONObject dish = this.jsonArray.getJSONObject(i);
            String x = dish.toString();
            int id = dish.getInt("id");
            String title = dish.getString("title");
            String image = dish.getString("image");
            this.dishes.add(i, new Dish(id, title, image));
        }*/
        JSONObject data = this.jsonArray.getJSONObject(0);
        JSONArray results = data.getJSONArray("results");
        for(int i = 0; i < results.length();i++)
        {
            JSONObject dish = results.getJSONObject(i);
            int id = dish.getInt("id");
            String title = dish.getString("title");
            String image = dish.getString("image");
            this.dishes.add(i, new Dish(id, title, image));
        }
    }
    @Override
    protected Void doInBackground(Object[] params) {

        AppState state = AppState.getInstance();
        try{
            Log.d("TAG", "in here");
            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("X-Mashape-Key", "OBeF8Xi0TPmsh5fQzlrz3mlWHK9hp1GgPkCjsnxQ32DzjRU0ME")
                    .header("Accept", "application/json")
                    .asJson();
            this.jsonArray = response.getBody().getArray();
            this.addDishes();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        AppState state = AppState.getInstance();
        state.setDishes(getDishes());
        super.onPostExecute(o);
        Intent i = new Intent(context, RecipeListActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }


}
