package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterPositionTest {
    
    @Test
    public void distance_of_other_point(){
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(0, 20)));
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(20, 0)));
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(20, 20)));
        assertEquals(20, CharacterPosition.create(20, 0).distance(CharacterPosition.create(0, 0)));
        assertEquals(20, CharacterPosition.create(0, 20).distance(CharacterPosition.create(0, 0)));
        assertEquals(20, CharacterPosition.create(20, 20).distance(CharacterPosition.create(0, 0)));
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(0, -20)));
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(-20, 0)));
        assertEquals(20, CharacterPosition.create(0, 0).distance(CharacterPosition.create(-20, -20)));
        assertEquals(20, CharacterPosition.create(-20, 0).distance(CharacterPosition.create(0, 0)));
        assertEquals(20, CharacterPosition.create(0, -20).distance(CharacterPosition.create(0, 0)));
        assertEquals(20, CharacterPosition.create(-20, -20).distance(CharacterPosition.create(0, 0)));
    }
}
