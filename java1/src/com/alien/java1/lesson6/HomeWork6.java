package com.alien.java1.lesson6;

import java.util.Random;
import java.util.Scanner;

public class HomeWork6 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();
    private static Animal[] animals;

    public static void main(String[] args) {
        System.out.println("Массив котов и собак");
        System.out.print("Укажите размер массива: ");
        int arraySize = scanner.nextInt();
        animals = new Animal[arraySize];

        for (int i = 0; i < animals.length; i++) {
            animals[i] = ((rnd.nextInt(10) + 1) >= 5 ? new Dog() : new Cat());
        }

        System.out.print("Попросим всех прыгнуть! Укажите высоту: ");
        float value = scanner.nextFloat();
        for (int i = 0; i < animals.length; i++) {
            animals[i].jump(value);
        }

        System.out.println(" ===== новый вид активности ===== ");

        System.out.print("Попросим всех пробежать! Укажите расстояние: ");
        value = scanner.nextFloat();
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(value);
        }

        System.out.println(" ===== новый вид активности ===== ");

        System.out.print("Попросим всех проплыть! Укажите высоту: ");
        value = scanner.nextFloat();
        for (int i = 0; i < animals.length; i++) {
            animals[i].swim(value);
        }
    }

}
