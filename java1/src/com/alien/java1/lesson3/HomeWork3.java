package com.alien.java1.lesson3;

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
                    playTheGame(1);
                    break;
                case 2:
                    playTheGame(2);
                    break;
                    default:
                        inProgr = false;
            }
        }
    }

    private static void playTheGame(int gameType) {
        boolean inGame = true;
        do {
            switch (gameType){
                case 1:
                    numberGame();
                    break;
                case 2:
                    wordGame();
                    break;
            }
            System.out.println("Хотите сыграть еще раз? 1 - Да, 0 - Нет");
            if (scanner.nextInt() == 0)
                inGame = false;

        } while (inGame);
    }

    private static void wordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String tryWord = "", answer;

        boolean inGame = true;
        System.out.println("Угадай загаданное слово!");
        String mysteryWorld = words[rnd.nextInt(words.length)];
        do {
            answer = "";
            System.out.println("");
            System.out.print("Введи слово:");
            tryWord = scanner.next().toLowerCase();

            if (tryWord.equals(mysteryWorld)){
                System.out.println("Вы выиграли! Победа!");
                inGame = false;
            }
            else {
                for (int i = 0; i < 15; i++) {

                    if (i < mysteryWorld.length() && i < tryWord.length()) {
                        if (mysteryWorld.charAt(i) == tryWord.charAt(i))
                            answer += tryWord.charAt(i);
                        else
                            answer += "#";
                    } else
                        answer += "#";
                }
                System.out.println("Результат:");
                System.out.println(answer);
            }
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
