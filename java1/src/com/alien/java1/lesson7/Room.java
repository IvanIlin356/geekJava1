package com.alien.java1.lesson7;

import com.alien.java1.lesson6.Cat;

public class Room {
    public static final int CAT_ARRAY_SIZE = 3;
    private Cat[] cats;
    private Plate plate;

    public Room() {
        // создадим в комнате котов и тарелку
        cats = new Cat[CAT_ARRAY_SIZE];

        for (int i = 0; i < CAT_ARRAY_SIZE; i++) {
            cats[i] = new Cat(this);
        }

        plate = new Plate(this);
    }

    public Cat[] getCats() {
        return cats;
    }

    public Plate getPlate() {
        return plate;
    }
}
