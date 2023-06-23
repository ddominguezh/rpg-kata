package com.crafters.murcia.rpg;

public class CharacterType {

    private CharacterTypes value;
    protected CharacterType(CharacterTypes value){
        this.value = value;
    }
    public static CharacterType create(String value){
        CharacterTypes type = CharacterTypes.valueOf(value);
        if(type != null){
            return new CharacterType(type);
        }
        return new CharacterType(CharacterTypes.Empty);
    }
    public String value(){
        return this.value.name();
    }

}
