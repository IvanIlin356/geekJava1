package com.alien.java1.lesson6;

import com.alien.java1.lesson7.Room;

import java.util.Random;

public class Cat extends Animal {
    private static Random rnd = new Random();
    private static String[] catNames = {"Матроскин", "Мурзик", "Барсик", "Геннадий", "Рыжик"};


    // ===== homework7 ======

    protected int hungerRateMax;
    protected int hungerRateCurrent;
    protected boolean wantsToEat;
    protected Room room;

    protected static final int HUNGER_TICK = 5;
    protected static final float HUNGER_LIMIT = 0.5f; // % от hungerRate после которого кот голоден

    public Cat(Room room){
        // homework7 part
        this.room = room;
        this.hungerRateMax = 50 + rnd.nextInt(50); // 50 - 100
        this.hungerRateCurrent = 30 + rnd.nextInt(50);
        this.wantsToEat = false;

        // homework6 part
        this.name = catNames[rnd.nextInt(5)];
    }

    public void update(){
        hungerRateCurrent -= HUNGER_TICK;
        if (hungerRateCurrent < 0) hungerRateCurrent = 0;
        //System.out.println(hungerRateCurrent + " " + hungerRateMax * HUNGER_LIMIT);

        if (hungerRateCurrent <= hungerRateMax * HUNGER_LIMIT){
            wantsToEat = true;
        }
        else {
            wantsToEat = false;
        }

        if (wantsToEat){
            System.out.println("Кот " + getName() + " хочет кушать и ищет миску! (" + hungerRateCurrent + "/" + hungerRateMax + ")");
            lookForAPlate();
        }
        else {
            System.out.println("Кот " + getName() + " сыт и весел! (" + hungerRateCurrent + "/" + hungerRateMax + ")");
        }
    }

    private void lookForAPlate() {
        if (room.getPlate().getCurrentFood() > 0){
            eat();
        }
        else{
            System.out.println("    " + getName() + " нашел миску, но она пуста!!!");
        }
    }

    private void eat() {
        if (hungerRateMax - hungerRateCurrent <= room.getPlate().getCurrentFood()){
            room.getPlate().eatFromPlate(hungerRateMax - hungerRateCurrent);
            hungerRateCurrent = hungerRateMax;
            System.out.println("    " + getName() + " наелся и отошел от миски");
        }
        else {
            hungerRateCurrent += room.getPlate().getCurrentFood();
            room.getPlate().eatFromPlate(room.getPlate().getCurrentFood());
            System.out.println("    " + getName() + " перекусил, но не наелся! (" + hungerRateCurrent + "/" + hungerRateMax + ")");
        }
    }


    // ===== homework6 =====

    public Cat(){
        // homework6 part
        this.name = catNames[rnd.nextInt(5)];
        this.maxJump = (rnd.nextFloat() * 2) + 1;
        this.maxRun = (rnd.nextFloat() * 100) + 150;
        this.maxSwim = 5 - (rnd.nextFloat() * 10);
    }

    @Override
    protected boolean jump(float value) {
        if (super.jump(value)){
            System.out.println("Кот " + name + " запрыгнул на шкаф! Высота - " + value + "м. Максимум - " + maxJump);
            return true;
        }
        else {
            System.out.println("Кот " + name + " не смог запрыгнуть на " + value + "м. Максимум - " + maxJump);
            return false;
        }
    }

    @Override
    protected boolean run(float value) {
        if (super.run(value)){
            System.out.println("Кот " + name + " пробежал " + value + "м. Максимум - " + maxRun);
            return true;
        }
        else {
            System.out.println("Кот " + name + " устал и не смог пробежать " + value + "м. Максимум - " + maxRun);
            return false;
        }

    }

    @Override
    protected boolean swim(float value) {
        if (super.swim(value)){
            System.out.println("Кот который смог! " + name + " проплыл " + value + "м. Максимум - " + maxSwim);
            return true;
        }
        else {
            System.out.println((maxSwim > 0) ? "Кот " + name + " не любит плавать, но может проплыть " + maxSwim + "м." : "Кот " + name + " не любит плавать совершенно");
            return false;
        }
    }
}
