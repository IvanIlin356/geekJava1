package com.alien.java1.lesson3;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
        boolean inProgr = true;
        while (inProgr) {
            System.out.println("");
            System.out.println("     ==========     ");
            System.out.println("");
            System.out.println("Введите 1 для запуска игры 'Угадай число'");
            System.out.println("Введите 2 для запуска игры 'Угадай слово'");
            System.out.println("Введите любое другое число для завершения");
            switch (scanner.nextInt()) {
                case 1:
                    guessTheNumber();
                    break;
                case 2:
                    //task2();
                    break;
                    default:
                        inProgr = false;
            }
        }
    }

    private static void guessTheNumber() {
        boolean inGame = true;
        do {
            numberGame();
            System.out.println("Хотите сыграть еще раз? 1 - Да, 0 - Нет");
            if (scanner.nextInt() == 0)
                inGame = false;

        } while (inGame);
    }

    private static void numberGame(){
        boolean inGame = true;
        short mysteryNumber = (short)rnd.nextInt(10);
        short tryCount = 3;
        short number = 0;
        System.out.println("Угадай число от 0 до 9!");
        System.out.println("(количество попыток: " + tryCount + ")");
        do {
            System.out.println("");
            System.out.print("Введи число: ");
            number = scanner.nextByte();

            if (number == mysteryNumber){
                System.out.println("Вы угадали! Победа!");
                inGame = false;
            } else if (number < mysteryNumber){
                System.out.println("Загаданное число больше!");
                System.out.println("(количество попыток: " + --tryCount + ")");
            }
            else {
                System.out.println("Загаданное число меньше!");
                System.out.println("(количество попыток: " + --tryCount + ")");
            }
            if (tryCount == 0){
                System.out.println("Вы проиграли!");
                inGame = false;
            }
        } while (inGame);
    }

}
