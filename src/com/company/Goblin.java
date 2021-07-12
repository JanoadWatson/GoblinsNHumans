package com.company;

public class Goblin {
     int health=100;
     String name ;
     String archetype;
     int strength;
     String weapon;
     String color;
    String pic;
    public Goblin( ){ }





    public String getName(){
        return name;
    }

    public int getStrength(){
        return strength;
    }

    public String getWeapon(){
        return weapon;
    }

    public String getColor(){
        return color;
    }

    public int getHealth(){
        return health;
    }
    public  String getArchetype(){
        return archetype;
    }
    public String getPic(){
        return pic;
    }


    public void setName(String name){
    this.name=name;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public void setStrength(int strength){
        this.strength= strength;
    }

    public void setWeapon(String weapon){
    this.weapon = weapon;
    }

    public void setArchetype(String archetype){
        this.archetype= archetype;

    }

    public void setColor(String color){
    this.color= color;
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
