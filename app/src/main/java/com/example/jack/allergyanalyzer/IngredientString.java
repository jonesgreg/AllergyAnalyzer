package com.example.jack.allergyanalyzer;
/**
 * Created by gregoryjones on 11/13/17.
 */

public class IngredientString {
    private static final IngredientString ourInstance = new IngredientString();
    public String ingredientString;

    static IngredientString getInstance() {
        return ourInstance;
    }

    public IngredientString() {
        this.ingredientString = null;
    }
}
