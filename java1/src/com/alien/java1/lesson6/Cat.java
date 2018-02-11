package com.alien.java1.lesson6;

import java.util.Random;

public class Cat extends Animal {
    private static Random rnd = new Random();
    private static String[] catNames = {"Матроскин", "Мурзик", "Барсик", "Геннадий", "Рыжик"};

    public Cat(){
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
