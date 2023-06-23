package com.crafters.murcia.rpg;

public class CharacterPosition {

    private int x;
    private int y;
    protected CharacterPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static CharacterPosition create(int x, int y){
        return new CharacterPosition(x, y);
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    public int distance(CharacterPosition other){
        int distanceOfX = Math.abs(this.x - other.x());
        int distanceOfY = Math.abs(this.y - other.y());
        if(distanceOfX > distanceOfY){
            return distanceOfX;
        }
        return distanceOfY;
    }
}
