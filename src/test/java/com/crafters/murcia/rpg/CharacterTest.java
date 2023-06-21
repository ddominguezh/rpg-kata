package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(character.alive());
    }

    @Test
    public void character_take_damage(){
        Character character = Character.create().takeDamage(100);
        assertEquals(900, character.health());
    }

    @Test
    public void health_becomes_0_and_the_character_dies(){
        Character character = Character.create().takeDamage(1005);
        assertEquals(0, character.health());
        assertFalse(character.alive());
    }
    
    @Test
    public void the_character_can_be_healed(){
        Character character = Character.create().takeDamage(100).heal(50);
        assertEquals(950, character.health());
    }

    @Test
    public void dead_characters_cannot_be_healed (){
        Character character = Character.create().takeDamage(1005).heal(50);
        assertEquals(0, character.health());
    }

    @Test
    public void healing_cannot_raise_health_above_init_health(){
        Character character = Character.create().takeDamage(100).heal(200);
        assertEquals(1000, character.health());
    }
}
