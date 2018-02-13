package com.alien.java1.lesson7;

import com.alien.java1.lesson6.Cat;

import java.util.Random;
import java.util.Scanner;

public class HomeWork7 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

    private static final int SLEEP_TIME = 3000;


    public static void main(String[] args) {
        System.out.println("Массив сытых котов");
        int timeCount = 1;

        Room room = new Room();

        System.out.println();

        while (timeCount != 0){

            System.out.println(" +++ Время " + timeCount + " +++ ");
            for (Cat cat : room.getCats()) {
                cat.update();
            }
            room.getPlate().update();
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

//            if (scanner.next() != null){
//                timeCount = 0;
//            }
        }
    }
}
