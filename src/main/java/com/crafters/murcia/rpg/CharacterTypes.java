package com.crafters.murcia.rpg;

public enum CharacterTypes {
    Melee(2),
    Ranged(20),
    Empty(0);
    private int maxDistance;
    CharacterTypes(int maxDistance){
        this.maxDistance = maxDistance;
    }
    public int maxDistance(){
        return this.maxDistance;
    }
}
