package com.crafters.murcia.rpg;

public class CharacterFaction {

    private CharacterFactionType value;
    protected CharacterFaction(CharacterFactionType value){
        this.value = value;
    }
    public static CharacterFaction create(String value){
        CharacterFactionType type = CharacterFactionType.valueOf(value);
        if(type != null){
            return new CharacterFaction(type);
        }
        return new CharacterFaction(CharacterFactionType.EMPTY);
    }
    public String value(){
        return this.value.name();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CharacterFaction other = (CharacterFaction) obj;
        if (value != other.value)
            return false;
        return true;
    }
    
}
