package com.alien.java1.lesson2;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
	 //task1();
	 //task2();
        task3();
    }

    // ===== task1
    private static void task1(){
        int[] array = new int[10];
        System.out.println("Задача по инвертированию массива");
        System.out.println("Введите 1, чтобы сгенерировать массив автоматически");
        System.out.println("Введите 0, чтобы начать самостоятельно заполнять array[10]");

        switch (scanner.nextByte()){
            case 1:
                for (int i = 0; i < array.length; i++) {
                    array[i] = rnd.nextInt(2);
                }
                System.out.println(printArray(array, false) + " - Исходный массив");
                System.out.println(printArray(array, true) + " - Инвертированный массив");
                break;
            case 0:
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Введите " + (i + 1) + " число: ");
                    array[i] = scanner.nextInt();
                }
                System.out.println(printArray(array, false) + " - Исходный массив");
                System.out.println(printArray(array, true) + " - Инвертированный массив");
                break;
                default:
                    System.out.println("Неправильный код! Завершение программы");
                    break;
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
    private static void task3(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Умножить на 2 цифры меньше 6 в массиве");
        System.out.println("Введите 1, чтобы использовать массив - 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1");
        System.out.println("Введите 2, чтобы сгенерировать массив автоматически");
        switch (scanner.nextInt()){
            case 1:
                System.out.println(printArray2(array, true) + " - Исходный массив");
                System.out.println(printArray2(array, false) + " - Новый массив");
                break;
            case 2:
                for (int i = 0; i < array.length; i++) {
                    array[i] = rnd.nextInt(11);
                }
                System.out.println(printArray2(array, true) + " - Исходный массив");
                System.out.println(printArray2(array, false) + " - Новый массив");
                break;
                default:
        }
    }

    private static String printArray2(int[] array, boolean original){
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (original) {
                result += array[i] + " ";
            }
            else {
                if (array[i] <= 6) {
                    result += array[i]*2 + " ";
                }
                else {
                    result += array[i] + " ";
                }

            }
        }
        return result;
    }
    // ===== task4
}
