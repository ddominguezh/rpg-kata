package com.crafters.murcia.rpg;

public class CharacterHealth {

    private double value;
    protected CharacterHealth(double value){
        this.value = value;
    }
    public static CharacterHealth create(double value){
        return new CharacterHealth(value);
    }
    public double value(){
        return this.value;
    }
    public boolean alive(CharacterDamage damage) {
        return value > damage.value();
    }
}
