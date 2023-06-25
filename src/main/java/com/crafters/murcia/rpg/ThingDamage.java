package com.crafters.murcia.rpg;

public class ThingDamage {

    private double value;
    protected ThingDamage(double value){
        this.value = value;
    }
    public static ThingDamage create(double value){
        if(value < 0){
            return new ThingDamage(0);
        }
        return new ThingDamage(value);
    }
    public double value(){
        return this.value;
    }

}
