package com.alien.java1.lesson7;

import com.alien.java1.lesson6.Cat;

import java.util.Random;
import java.util.Scanner;

public class HomeWork7 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();
    private static final int ARRAY_SIZE = 3;
    private static final int SLEEP_TIME = 3000;


    public static void main(String[] args) {
        int timeCount = 1;

        Cat[] cats = new Cat[ARRAY_SIZE];

        System.out.println("Массив сытых котов");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            cats[i] = new Cat();
        }

        //System.out.println("введите любое слово, чтобы остановить кошачий цикл");
        Plate plate = new Plate();
        System.out.println();

        while (timeCount != 0){

            System.out.println(" +++ Время " + timeCount + " +++ ");
            for (Cat cat : cats) {
                cat.update();
            }
            System.out.println();

            try
            {
                Thread.sleep(SLEEP_TIME);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            timeCount++;


//            if (scanner.hasNext()){
//                inProgr = false;
//            }
        }

    }

}
