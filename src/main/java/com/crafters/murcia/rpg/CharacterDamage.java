package com.crafters.murcia.rpg;

public class CharacterDamage {

    private double value;
    protected CharacterDamage(double value){
        this.value = value;
    }
    public static CharacterDamage create(double value){
        if(value < 0){
            return new CharacterDamage(0);
        }
        return new CharacterDamage(value);
    }
    public double value(){
        return this.value;
    }

}
