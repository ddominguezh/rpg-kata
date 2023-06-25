package com.crafters.murcia.rpg;

import java.util.UUID;

public class Thing {
    
    private ThingId id;
    private ThingHealth health;
    private ThingDamage damage;
    private ThingType type;
    protected Thing(
        ThingId id,
        ThingHealth health,
        ThingDamage damage,
        ThingType type
    ){
        this.id = id;
        this.health = health;
        this.damage = damage;
        this.type = type;
    }
    public static Thing create(String type, double health){
        return new Thing(
            ThingId.create(UUID.randomUUID().toString()), 
            ThingHealth.create(health), 
            ThingDamage.create(0), 
            ThingType.create(type)
        );
    }
    protected static Thing create(String id, double health, double damage, String type){
        return new Thing(
            ThingId.create(UUID.randomUUID().toString()), 
            ThingHealth.create(health), 
            ThingDamage.create(damage), 
            ThingType.create(type)
        );
    }
    public double health() {
        double result = health.value() - damage.value();
        if(result < 0){
            return 0;
        }
        return result;
    }
    public boolean destroy() {
        return health.destroy(damage);
    }
    public Thing takeDamage(Character character) {
        return Thing.create(
            this.id.value(), 
            this.health.value(), 
            this.damage.value() + character.howMuchDamageDoICause(), 
            this.type.value()
        );
    }

}
