package com.company;

public class Wizard extends Human{
    private String magic;


    public Wizard(){

         weapon = "none";
         health = 100;
        strength = 90;
        setMagic("Lightning Bolts");
        archetype= "Wizard";
        pic = "\uD83E\uDDDD";
    }



    public String getMagic(){
        return magic;
    }

    public void setMagic(String magic){
        this.magic= magic;
    }

    public String getPic(){
        return pic;
    }
}
