package com.alien.java1.lesson2;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
        boolean inProgr = true;
        while (inProgr) {
            System.out.println("");
            System.out.println("     ==========     ");
            System.out.println("");
            System.out.println("Введите номер задания 1 - 7");
            System.out.println("Введите любое другое число для завершения");
            switch (scanner.nextInt()) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7_2();
                    break;
                    default:
                        inProgr = false;
            }
        }
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
    private static void task4(){
        System.out.println("Создание квадратной матрицы и замена диагоналей на 1");
        System.out.print("Введите размер массива:");
        int arraySize = scanner.nextInt();
        int[][] array = new int[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                array[i][j] = rnd.nextInt(10);
            }
        }
        System.out.println("Исходный массив:");
        printArray3(array, arraySize, true);
        System.out.println("Новый массив:");
        printArray3(array, arraySize, false);
    }
    private static void printArray3(int[][] array, int arraySize, boolean original){
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (original)
                    System.out.print(array[i][j] + " ");
                else {
                    if ((i == j) || (i + j == arraySize - 1))
                        System.out.print("1 ");
                    else
                        System.out.print(array[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    // ===== task5
    private static void task5(){
        final int MAX_VALUE = 100;
        System.out.println("Зададим массив и найдем Min и Max");
        System.out.print("Введите длину массива: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(MAX_VALUE);
        }

        int max = 0, min = MAX_VALUE;

        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) max = array[i];
            if (array[i] <= min) min = array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Min = " + min + ", Max = " + max);
    }

    // ===== task6
    private static void task6(){
        System.out.println("Зададим массив и проверим есть ли место, в котором сумма левой и правой части массива равны");
        System.out.print("Введите длину массива: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];
        //int[] array = {10,5,3,2};
        int arraySum = 0, leftSum = 0, rightSum = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(10);
            arraySum += array[i];
        }
        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            if (leftSum == arraySum / 2) {
                rightSum += array[i];
            }
            else {
                leftSum += array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        if (leftSum == rightSum)
            System.out.println("Место, в котором сумма левой и правой части массива равны ЕСТЬ, сумма = " + arraySum / 2);
        else
            System.out.println("Места, в котором сумма левой и правой части массива равны НЕТУ");
    }

    // ===== task7
    private static void task7(){
        System.out.println("Сместим элементы массива на n позиций");
        System.out.println("Программа работает не всегда нестабильно в случае четного размера массива и шага");

        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        System.out.print("Введите размер смещения: ");
        int step = scanner.nextInt();
        if (step > arraySize) step = step % arraySize;

        int[] array = new int[arraySize];

        System.out.println("Исходный массив:");
        for (int i = 0; i < arraySize; i++){
            array[i] = rnd.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        int curCell = 0, newCell = 0, buff1 = 0, buff2 = 0, buff3 = 0;
        boolean buff = true;
        boolean strangeCondition = ((arraySize % 2 == 0) && (step % 2 == 0));

        for (int i = 1; i <= arraySize; i++){
            if ((curCell == arraySize - step)){
                buff3 = (buff ? buff1 : buff2);
                //System.out.println(curCell + " " + buff3);
            }
            if (step < 0) step = arraySize - Math.abs(step);
            newCell = curCell + step;
            if (strangeCondition) {
                if (newCell > arraySize) newCell -= arraySize;
                if (newCell == arraySize) newCell -= arraySize - 1;
                //if (newCell < 0) newCell += arraySize - 1;
                //if (newCell == 0) newCell += arraySize - 2;
            }
            else {
                if (newCell >= arraySize) newCell -= arraySize;
                if (newCell < 0) newCell += arraySize;
            }

            if (i == 1) buff1 = array[curCell];

            if (buff) {
                buff2 = array[newCell];
            }
            else {
                buff1 = array[newCell];
            }

            array[newCell] = (buff ? buff1 : buff2);

            if (buff) {
                buff1 = array[curCell];
            }
            else {
                buff2 = array[curCell];
            }

            buff = !buff;
            curCell = newCell;
        }


        if (strangeCondition) {
            if (step >= 0) array[0] = buff3;
            if (step < 0) {
                // привет, костыли!
                buff1 = array[arraySize-3];
                buff2 = array[arraySize-2];
                buff3 = array[arraySize-1];

                array[arraySize-3] = buff3;
                array[arraySize-2] = buff1;
                array[arraySize-1] = buff2;
            }
        }

        System.out.println("Новый массив:");
        for (int i = 0; i < arraySize; i++){
            System.out.print(array[i] + " ");
        }

    }

    private static void task7_2(){
        System.out.println("Сместим элементы массива на n позиций");

        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        System.out.print("Введите размер смещения: ");
        int step = scanner.nextInt();
        if (step > arraySize) step = step % arraySize;

        int[] array = new int[arraySize];
        boolean inProgr = true;

        System.out.println("Исходный массив:");
        for (int i = 0; i < arraySize; i++){
            array[i] = rnd.nextInt(10);
            System.out.print(array[i] + " ");
        }

        System.out.println("");

        int curCell = 0, bufCell = 0, buff1 = 0;

        if (step < 0) step = arraySize - Math.abs(step);
        if (step == 0) {
            inProgr = false;
        }

        curCell = step;
        bufCell = curCell - 1;

        while (inProgr) {
            buff1 = array[curCell];
            array[curCell] = array[bufCell];
            array[bufCell] = buff1;
            curCell++;
            if (curCell > arraySize - 1) curCell = 0;
            if (curCell == bufCell) inProgr = false;
        }

        System.out.println("Новый массив:");
        for (int i = 0; i < arraySize; i++){
            System.out.print(array[i] + " ");
        }

    }
}
