package com.crafters.murcia.rpg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return this.values.stream().filter(value -> factions.values.contains(value)).findFirst().isPresent();
    }
    public String[] values(){
        return this.values.stream().map(CharacterFaction::value).toArray(String[]::new);
    }
}
