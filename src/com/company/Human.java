package com.company;

public class Human {

     String name ;
     int strength;
     String weapon;
     String archetype;
     int health;
     String pic;

    public Human(){


    };

//    public Human(String name, int strength, String weapon, String archetype,int health ){
//        this.name= name ;
//        this.strength = strength;
//        this.weapon = weapon;
//        this.archetype=archetype;
//        this.health = health;
//
//    }

    public String getName(){
        return name;
    }

    public String getPic(){
        return pic;
    }

    public int getStrength(){
        return strength;
    }

    public String getWeapon(){
        return weapon;
    }

    public String getArchetype(){
        return archetype;
    }

    public int getHealth(){
        return health;
    }


    public void setName(String name){
        this.name = name;

    }

    public void setStrength(){

    }


    public void setHealth(int newHealth){
        health=newHealth;

    }

    public void setWeapon(){

    }

    public void setArchetype(){

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", pic=" + strength +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                ", archetype='" + archetype + '\'' +
                ", health=" + health +
                '}';
    }
}
