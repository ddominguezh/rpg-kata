package com.crafters.murcia.rpg;

public class ThingType {

    private ThingTypes value;
    protected ThingType(ThingTypes value){
        this.value = value;
    }
    public static ThingType create(String value){
        ThingTypes type = ThingTypes.valueOf(value);
        if(type != null){
            return new ThingType(type);
        }
        return new ThingType(ThingTypes.EMPTY);
    }
    public String value(){
        return this.value.name();
    }

}
