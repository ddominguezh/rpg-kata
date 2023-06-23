package com.crafters.murcia.rpg;

public class CharacterId {

    private String value;
    protected CharacterId(String value){
        this.value = value;
    }
    public static CharacterId create(String value){
        return new CharacterId(value);
    }
    public String value(){
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CharacterId other = (CharacterId) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
