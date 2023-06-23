package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void character_starting_with_init_health(){
        Character character = Character.create();
        assertEquals(1000, character.health(), 1);
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
        Character character = Character.create().takeDamage(Character.create());
        assertEquals(900, character.health(), 1);
    }

    @Test
    public void health_becomes_0_and_the_character_dies(){
        Character enemy = Character.create();
        Character character = Character.create();
        do{
            character = character.takeDamage(enemy);
        }while(character.health() > 0);
        assertEquals(0, character.health(), 1);
        assertFalse(character.alive());
    }
    
    @Test
    public void the_character_can_be_healed(){
        Character character = Character.create();
        character = character.takeDamage(Character.create()).heal(character);
        assertEquals(950, character.health(), 1);
    }

    @Test
    public void dead_characters_cannot_be_healed (){
        Character enemy = Character.create();
        Character character = Character.create();
        do{
            character = character.takeDamage(enemy);
        }while(character.health() > 0);
        character = character.heal(character);
        assertEquals(0, character.health(), 1);
    }

    @Test
    public void healing_cannot_raise_health_above_init_health(){
        Character character = Character.create().takeDamage(Character.create());
        character = character.heal(character);
        character = character.heal(character);
        character = character.heal(character);
        character = character.heal(character);
        assertEquals(1000, character.health(), 1);
    }

    @Test
    public void a_character_cannot_deal_damage_to_itself(){
        Character character = Character.create();
        assertEquals(1000, character.takeDamage(character).health());
    }

    @Test
    public void a_character_can_only_heal_itself(){
        Character enemy = Character.create();
        Character character = Character.create().takeDamage(enemy).heal(enemy);
        assertEquals(900, character.health(), 1);
    }

    @Test
    public void if_the_target_is_5_or_more_levels_above_the_attacker_damage_is_reduced_by_50(){
        Character enemy = Character.create();
        Character character = Character.create().levelUp(5).takeDamage(enemy);
        assertEquals(950, character.health(), 1);
    }

    @Test
    public void if_the_target_is_5_or_more_levels_below_the_attacker_damage_is_increased_by_50(){
         Character enemy = Character.create().levelUp(5);
        Character character = Character.create().takeDamage(enemy);
        assertEquals(850, character.health(), 1);
    }
}
