package com.crafters.murcia.rpg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CharacterFactions {
    
    private List<CharacterFaction> values;
    protected CharacterFactions(List<CharacterFaction> values){
        this.values = values;
    }
    public static CharacterFactions create(String... values){
        return new CharacterFactions(
            Arrays.stream(values).map(CharacterFaction::create).toList()
        );
    }
    public boolean isAllies(CharacterFactions factions){
        return this.values.stream()
            .filter(value -> value.isNotEmpty())
            .filter(value -> factions.values.contains(value))
            .findFirst()
            .isPresent();
    }
    public String[] values(){
        return this.values.stream().map(CharacterFaction::value).toArray(String[]::new);
    }
    public CharacterFactions concat(String[] factions) {
        return new CharacterFactions(
            Stream.concat(Arrays.stream(this.values()), Arrays.stream(factions)).map(CharacterFaction::create).toList()
        );
    }
     public CharacterFactions remove(String[] factions) {
        List<String> removeFactions = Arrays.asList(factions);
        return new CharacterFactions(
            Arrays.stream(this.values()).filter(value -> !removeFactions.contains(value)).map(CharacterFaction::create).toList()
        );
    }
    public String[] names() {
        return this.values.stream().map(CharacterFaction::name).toArray(String[]::new);
    }
   
}
