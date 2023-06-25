package com.crafters.murcia.rpg;

public enum CharacterFactionType {
    SPACE_MARINES("Space Marines"),
    TYRANIDS("Tyranids"),
    NECRONS("Necrons"),
    CHAOS_SPACE_MARINES("Chaos Space Marines"),
    ADEPTA_SORORITAS("Adepta Sororitas"),
    ORKS("Orks"),
    IMPERIUM_OF_MAN("Imperium of Man"),
    ADEPTUS_MECHANICUS("Adeptus Mechanicus"),
    EMPTY("");
    String name;
    CharacterFactionType(String name){
        this.name = name;
    }
    public String typeName(){
        return this.name;
    }
}
