package com.crafters.murcia.rpg;

public class CharacterDamage {

    private int value;
    protected CharacterDamage(int value){
        this.value = value;
    }
    public static CharacterDamage create(int value){
        return new CharacterDamage(value);
    }
    public int value(){
        return this.value;
    }

}
