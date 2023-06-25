package com.crafters.murcia.rpg;

import java.util.UUID;

public class Character {

    private CharacterId id;
    private CharacterHealth health;
    private CharacterLevel level;
    private CharacterDamage damage;
    private CharacterType type;
    private CharacterPosition position;
    private CharacterFactions factions;
    protected Character(
        CharacterId id,
        CharacterHealth health,
        CharacterLevel level,
        CharacterDamage damage,
        CharacterType type,
        CharacterPosition position,
        CharacterFactions factions
    ){
        this.id = id;
        this.health = health;
        this.level = level;
        this.damage = damage;
        this.type = type;
        this.position = position;
        this.factions = factions;
    }
    public static Character create() {
        return Character.create(CharacterTypes.Empty.name(), CharacterFactionType.EMPTY.name());
    }
    public static Character create(String type, String... factions) {
        return new Character(
            CharacterId.create(UUID.randomUUID().toString()),
            CharacterHealth.create(1000),
            CharacterLevel.create(1),
            CharacterDamage.create(0),
            CharacterType.create(type),
            CharacterPosition.create(0, 0),
            CharacterFactions.create(factions)
        );
    }
    protected static Character create(
        String id, 
        double health, 
        int level, 
        double damage, 
        String type, 
        int x, 
        int y,
        String... factions) {
        return new Character(
            CharacterId.create(id),
            CharacterHealth.create(health),
            CharacterLevel.create(level),
            CharacterDamage.create(damage),
            CharacterType.create(type),
            CharacterPosition.create(x, y),
            CharacterFactions.create(factions)
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
    public Character takeDamage(Character enemy) {
        if(this.equals(enemy) || this.factions.isAllies(enemy.factions)){
            return this;
        }
        if(enemy.outOfRange(this.position)){
            return this;
        }
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value() + howMuchDamageDoTheyCauseMe(enemy),
            this.type.value(),
            this.position.x(),
            this.position.y(),
            this.factions.values()
        );
    }

    private boolean outOfRange(CharacterPosition position) {
        return this.position.distance(position) > this.type.maxDistance();
    }

    public Character heal(Character character) {
        if(!this.equals(character) && !this.factions.isAllies(character.factions)){
            return this;
        }
        if(!this.alive()){
            return this;
        }
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value() - 50,
            this.type.value(),
            this.position.x(),
            this.position.y(),
            this.factions.values()
        );
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
            this.damage.value(),
            this.type.value(),
            this.position.x(),
            this.position.y(),
            this.factions.values()
        );
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
    public Character move(int x, int y) {
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value(),
            this.type.value(),
            this.position.x() + x,
            this.position.y() + y,
            this.factions.values()
        );
    }

    public String factions() {
        return String.join(", ", this.factions.names());
    }
    
    public Character addFactions(String... factions){
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value(),
            this.type.value(),
            this.position.x(),
            this.position.y(),
            this.factions.concat(factions).values()
        );
    }

    public Character removeFactions(String... factions){
        return Character.create(
            this.id.value(),
            this.health.value(), 
            this.level.value(), 
            this.damage.value(),
            this.type.value(),
            this.position.x(),
            this.position.y(),
            this.factions.remove(factions).values()
        );
    }
    
}
