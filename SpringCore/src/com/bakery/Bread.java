package com.bakery;

public class Bread {
    private static final int READY_LEVEL=5;

    private int level;
    private final String name;

    public Bread(String name) {
        this.name = name;
    }

    public boolean isReady(){
        return level==READY_LEVEL;
    }

    public void bake(){
        ++level;
    }

    @Override
    public String toString() {
        return String.format("Bread{level=%d, name='%s'}", level, name);
    }
}


