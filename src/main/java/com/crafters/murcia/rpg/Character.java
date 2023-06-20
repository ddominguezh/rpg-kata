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

    public int health() {
        return health.value() - damage.value();
    }
    public int level() {
        return level.value();
    }
    public boolean alive() {
        return health.alive(damage);
    }
    
}
