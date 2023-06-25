package com.crafters.murcia.rpg;

public class ThingHealth {

    private double value;
    protected ThingHealth(double value){
        this.value = value;
    }
    public static ThingHealth create(double value){
        return new ThingHealth(value);
    }
    public double value(){
        return this.value;
    }
    public boolean destroy(ThingDamage damage) {
        return value - damage.value() <= 0;
    }
}
