package com.crafters.murcia.rpg;

public class CharacterLevel {

    private int value;
    protected CharacterLevel(int value){
        this.value = value;
    }
    public static CharacterLevel create(int value){
        return new CharacterLevel(value);
    }
    public int value(){
        return this.value;
    }

}
