package com.alien.java1.lesson6;

public class Animal {
    protected String name;
    protected float maxJump;
    protected float maxRun;
    protected float maxSwim;

    protected boolean jump(float value){
        if (value <= maxJump) return true;
        return false;
    }

    protected boolean run(float value){
        if (value <= maxRun) return true;
        return false;
    }

    protected boolean swim(float value){
        if (value <= maxSwim) return true;
        return false;
    }

    public String getName() {
        return name;
    }
}
