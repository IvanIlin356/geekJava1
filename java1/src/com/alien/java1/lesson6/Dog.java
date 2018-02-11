package com.alien.java1.lesson6;

import java.util.Random;

public class Dog extends Animal {
    private static Random rnd = new Random();
    private static String[] dogNames = {"Шарик", "Тузик", "Бобик", "Барбос", "Мухтар"};

    public Dog(){
        this.name = dogNames[rnd.nextInt(5)];
        this.maxJump = rnd.nextFloat();
        this.maxRun = (rnd.nextFloat() * 200) + 400;
        this.maxSwim = (rnd.nextFloat() * 10) + 5;
    }

    @Override
    protected boolean jump(float value) {
        if (super.jump(value)){
            System.out.println("Пес " + name + " взял барьер! Высота - " + value + "м. Максимум - " + maxJump);
            return true;
        }
        else {
            System.out.println("Пес " + name + " не смог перепрыгнуть высоту " + value + "м. Максимум - " + maxJump);
            return false;
        }
    }

    @Override
    protected boolean run(float value) {
        if (super.run(value)){
            System.out.println("Пес " + name + " пробежал " + value + "м. Максимум - " + maxRun);
            return true;
        }
        else {
            System.out.println("Пес " + name + " устал и не смог пробежать " + value + "м. Максимум - " + maxRun);
            return false;
        }

    }

    @Override
    protected boolean swim(float value) {
        if (super.swim(value)){
            System.out.println("Пес " + name + " проплыл " + value + "м. Максимум - " + maxSwim);
            return true;
        }
        else {
            System.out.println("Пес " + name + " не смог проплыть " + value + "м. Максимум - " + maxSwim);
            return false;
        }
    }
}
