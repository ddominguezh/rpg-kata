package com.crafters.murcia.rpg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterFactionsTests {
    
    @Test
    public void is_allies(){
        CharacterFactions factions = CharacterFactions.create(
            CharacterFactionType.ADEPTA_SORORITAS.name(), 
            CharacterFactionType.ADEPTUS_MECHANICUS.name(),
            CharacterFactionType.ORKS.name()
        );
        assertTrue(
            factions.isAllies(
                CharacterFactions.create(
                    CharacterFactionType.IMPERIUM_OF_MAN.name(), 
                    CharacterFactionType.ORKS.name(), 
                    CharacterFactionType.TYRANIDS.name(),
                    CharacterFactionType.CHAOS_SPACE_MARINES.name()
                )
            )
        );
    }

    @Test
    public void is_not_allies(){
        CharacterFactions factions = CharacterFactions.create(
            CharacterFactionType.ADEPTA_SORORITAS.name(), 
            CharacterFactionType.ADEPTUS_MECHANICUS.name()
        );
        assertFalse(
            factions.isAllies(
                CharacterFactions.create(
                    CharacterFactionType.IMPERIUM_OF_MAN.name(), 
                    CharacterFactionType.ORKS.name(), 
                    CharacterFactionType.TYRANIDS.name(),
                    CharacterFactionType.CHAOS_SPACE_MARINES.name()
                )
            )
        );
    }

    @Test
    public void empty_factions_are_not_allies(){
        assertFalse(CharacterFactions.create(CharacterFactionType.EMPTY.name()).isAllies(CharacterFactions.create(CharacterFactionType.EMPTY.name())));
    }
}
