package com.alien.java1.lesson2;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	 //task1();
	 task2();
    }

    // ===== task1
    private static void task1(){
        int[] array = new int[10];
        Random rnd = new Random();
        boolean isError = false;
        System.out.println("Задача по инвертированию массива");
        System.out.println("Введите 1, чтобы сгенерировать массив автоматически");
        System.out.println("Введите 0, чтобы начать самостоятельно заполнять array[10]");

        switch (scanner.nextByte()){
            case 1:
                for (int i = 0; i < array.length; i++) {
                    array[i] = rnd.nextInt(2);
                }
                break;
            case 0:
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Введите " + (i + 1) + " число: ");
                    array[i] = scanner.nextInt();
                }
                break;
                default:
                    System.out.println("Неправильный код! Завершение программы");
                    isError = true;
                    break;
                    
        }

        if (!isError){
            System.out.println(printArray(array, false) + " - Исходный массив");
            System.out.println(printArray(array, true) + " - Инвертированный массив");
        }

    }
    private static String printArray(int[] array, boolean isInverted){
        String result = "";
        for (int i = 0; i < array.length ; i++) {
            switch (array[i]){
                case 1:
                    result += (isInverted ? "0 " : "1 ");
                    break;
                case 0:
                    result += (isInverted ? "1 " : "0 ");
                    break;
                    default:
                        result += "Неправильный номер! ";
            }
        }
        return result;
    }
    
    // ===== task2
    private static void task2(){
        int[] array = new int[8];
        System.out.println("Заполнение массива значениями с заданным шагом");
        System.out.print("Укажите начальное значение: ");
        int arrayStart = scanner.nextInt();
        System.out.print("Укажите шаг: ");
        int arrayStep = scanner.nextInt();
        System.out.println("Полученный массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayStart + (i * arrayStep);
            System.out.print(array[i] + " ");
        }
    }

    // =====task3
}
