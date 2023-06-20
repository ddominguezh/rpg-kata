package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void character_starting_with_init_health(){
        Character character = Character.create();
        assertEquals(1000, character.health());
    }

    @Test
    public void character_starting_with_init_level(){
        Character character = Character.create();
        assertEquals(1, character.level());
    }

    @Test
    public void character_starting_with_init_alive(){
        Character character = Character.create();
        assertEquals(Boolean.TRUE, character.alive());
    }
    
}
