package com.alien.java1.lesson7;

import com.alien.java1.lesson6.Cat;

public class Plate {
    private static final int MAX_FOOD = 100 * (Room.CAT_ARRAY_SIZE - 1);
    private int currentFood;
    private Room room;

    public Plate(Room room){
        fullThePlate();
        this.room = room;  // тарелка ведь должна знать, где стоит?
    }

    public void update(){
        System.out.println();
        if (currentFood == 0){
            fullThePlate();
        }
        else {
            System.out.println("Тарелка: " + currentFood + " / " + MAX_FOOD);
        }
    }

    public void fullThePlate(){
        this.currentFood = MAX_FOOD;
        System.out.println(" === Тарелка полна еды! === ");
    }

    public void eatFromPlate(int amount) {
        this.currentFood -= amount;
        if (currentFood < 0) currentFood = 0;
    }

    public int getCurrentFood() {
        return currentFood;
    }
}
