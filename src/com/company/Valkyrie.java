package com.company;

import com.company.Human;

public class Valkyrie extends Human {


    public Valkyrie(){
        weapon = "2 daggers";
         health = 100;
         strength = 80;
         archetype = "Valkyrie";
         pic = 	"\uD83C\uDFC3\u200D";
    }

    public String getPic(){
        return pic;
    }
}
