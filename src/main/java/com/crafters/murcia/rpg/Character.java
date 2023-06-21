package com.crafters.murcia.rpg;

public class Character {

    private CharacterHealth health;
    private CharacterLevel level;
    private CharacterDamage damage;
    protected Character(
        CharacterHealth health,
        CharacterLevel level,
        CharacterDamage damage
    ){
        this.health = health;
        this.level = level;
        this.damage = damage;
    }
    public static Character create() {
        return new Character(
            CharacterHealth.create(1000),
            CharacterLevel.create(1),
            CharacterDamage.create(0)
        );
    }
    protected static Character create(int health, int level, int damage) {
        return new Character(
            CharacterHealth.create(health),
            CharacterLevel.create(level),
            CharacterDamage.create(damage)
        );
    }
    public int health() {
        int result = health.value() - damage.value();
        if(result < 0){
            return 0;
        }
        return result;
    }
    public int level() {
        return level.value();
    }
    public boolean alive() {
        return health.alive(damage);
    }
    public Character takeDamage(int damage) {
        return Character.create(
            this.health.value(), 
            this.level.value(), 
            this.damage.value() + damage);
    }
    public Character heal(int health) {
        if(!this.alive()){
            return this;
        }
        return Character.create(
            this.health.value(), 
            this.level.value(), 
            this.damage.value() - health);
    }
    
}
