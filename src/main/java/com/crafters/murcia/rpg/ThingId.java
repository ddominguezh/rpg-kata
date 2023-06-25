package com.crafters.murcia.rpg;

public class ThingId {

    private String value;
    protected ThingId(String value){
        this.value = value;
    }
    public static ThingId create(String value){
        return new ThingId(value);
    }
    public String value(){
        return this.value;
    }

}
