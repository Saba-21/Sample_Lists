package com.example.giorgi.sample_lists;

public class Card {

    int img;
    String txt, name;

    public Card(int img, String txt, String name){
        this.txt = txt;
        this.img = img;
        this.name = name;
    }

    public int getImg(){
        return img;
    }

    public String getTxt(){
        return txt;
    }

    public String getName(){
        return name;
    }

}
