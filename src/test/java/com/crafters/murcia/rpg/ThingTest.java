package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ThingTest {
    
    @Test
    public void thing_take_damage(){
        Thing thing = Thing.create(ThingTypes.TREE.name(), 2000).takeDamage(Character.create());
        assertEquals(1900, thing.health(), 1);
    }

    @Test
    public void thing_destroyed(){
        Thing thing = Thing.create(ThingTypes.TREE.name(), 150).takeDamage(Character.create());
        assertFalse(thing.destroy());
        assertTrue(thing.takeDamage(Character.create()).destroy());
    }

}
