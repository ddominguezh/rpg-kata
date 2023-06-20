package com.crafters.murcia.rpg;

public class CharacterHealth {

    private int value;
    protected CharacterHealth(int value){
        this.value = value;
    }
    public static CharacterHealth create(int value){
        return new CharacterHealth(value);
    }
    public int value(){
        return this.value;
    }
    public boolean alive(CharacterDamage damage) {
        return value > damage.value();
    }
}
