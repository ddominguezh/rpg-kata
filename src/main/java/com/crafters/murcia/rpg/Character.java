package com.crafters.murcia.rpg;

import java.util.UUID;

public class Character {

    private CharacterId id;
    private CharacterHealth health;
    private CharacterLevel level;
    private CharacterDamage damage;
    protected Character(
        CharacterId id,
        CharacterHealth health,
        CharacterLevel level,
        CharacterDamage damage
    ){
        this.id = id;
        this.health = health;
        this.level = level;
        this.damage = damage;
    }
    public static Character create() {
        return new Character(
            CharacterId.create(UUID.randomUUID().toString()),
            CharacterHealth.create(1000),
            CharacterLevel.create(1),
            CharacterDamage.create(0)
        );
    }
    protected static Character create(String id, double health, int level, double damage) {
        return new Character(
            CharacterId.create(id),
            CharacterHealth.create(health),
            CharacterLevel.create(level),
            CharacterDamage.create(damage)
        );
    }
    public double health() {
        double result = health.value() - damage.value();
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
    public Character takeDamage(Character character) {
        if(this.equals(character)){
            return this;
        }
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value() + howMuchDamageDoTheyCauseMe(character));
    }
    public Character heal(Character character) {
        if(!this.equals(character)){
            return this;
        }
        if(!this.alive()){
            return this;
        }
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value() - 50);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Character other = (Character) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public Character levelUp(int level) {
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value() + level, 
            this.damage.value());
    }
    
    public double howMuchDamageDoTheyCauseMe(Character enemy){
        if(this.level() - enemy.level() >= 5){
            return enemy.howMuchDamageDoICause() - ( enemy.howMuchDamageDoICause() * (50.0 / 100.0));
        }
        if(this.level() - enemy.level() <= -5){
            return enemy.howMuchDamageDoICause() + ( enemy.howMuchDamageDoICause() * (50.0 / 100.0));
        }
        return enemy.howMuchDamageDoICause();
    }

    public double howMuchDamageDoICause(){
        return 100;
    }
}
