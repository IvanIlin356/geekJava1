package com.alien.java1.lesson7;

import com.alien.java1.lesson6.Cat;

public class Plate {
    private static final int MAX_FOOD = 100;
    private int currentFood;

    public Plate(){
        incFood();
    }

    public void incFood(){
        this.currentFood = MAX_FOOD;
        System.out.println("Тарелка полна еды!");
    }

    public void decFood(Cat cat, int amount){
        //if (currentFood <)
    }
}
