package com.example.gregoryjones.ingredientsandrecipes;

/**
 * Created by gregoryjones on 11/13/17.
 */

public class Dish {
    private int id;
    private String title;
    private String image;


    public Dish(int id, String title, String image){
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public int getID(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getImage(){
        return this.image;
    }

}
