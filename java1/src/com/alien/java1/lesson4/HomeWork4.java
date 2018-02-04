package com.alien.java1.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();
    private static final char DOT_EMPTY = '.';  // 0
    private static final char DOT_X = 'X'; // 1
    private static final char DOT_O = 'O'; // 2
    private static boolean isUserFirst;
    private static char[][] field;
    private static short fieldSize, rowToWin;
    private static int row, col;
    private static Map<Character, String> names = new HashMap<>();

    public static void main(String[] args) {
        boolean inGame = true;
        while (inGame) {
            System.out.println("");
            System.out.println("     ==========     ");
            System.out.println("");
            System.out.println("Сыграем в Крестики-Нолики!");
            ticTakToe();

            System.out.println("Хотите сыграть еще раз? 1 - Да, 0 - Нет");
            if (scanner.nextInt() == 0)
                inGame = false;
        }
    }

    private static void ticTakToe(){
        boolean inGame = true;
        initGame();
        printField();

        do {
            playerTurn();
            printField();
            System.out.println(checkForWin(DOT_X));
        }while (!checkForWin(DOT_X));

        printField();

    }

    private static boolean whosFirst() {
        return (rnd.nextInt(2) == 1 ? true : false);
    }

    private static void printField(){
        System.out.println("Игровое поле:");
        System.out.print("  ");
        for (int i = 0; i < field.length; i++){
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < field.length; j++){
                    System.out.print(field[i][j] + " ");
                }
            System.out.println();
        }
    }

    private static void initGame(){
        names.put(DOT_X, "Игрок");
        names.put(DOT_O, "Компьютер");

        System.out.print("Введите размер поля: ");
        fieldSize = scanner.nextShort();
        System.out.print("Введите длину ряда для победы: ");
        rowToWin = scanner.nextShort();
        if (rowToWin > fieldSize || rowToWin <= 0){
            rowToWin = fieldSize;
            System.out.println("Длина ряда для победы приравнена размеру поля");
        }

        isUserFirst = whosFirst();
        System.out.println();
        if (isUserFirst)
            System.out.println("Первым ходит " + names.get(DOT_X));
        else
            System.out.println("Первым ходит " + names.get(DOT_O));

        field = new char[fieldSize][fieldSize];

        for (char[] aField : field) {
            for (int j = 0; j < field.length; j++){
                aField[j] = DOT_EMPTY;
            }
        }
        System.out.println();
    }

    private static void playerTurn(){
        do {
            System.out.println("Введите координаты ячейки в формате [строка] [колонка]");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isCellValid(row, col));
        field[row][col] = DOT_X;
    }

    private static boolean checkForWin(char dot){
        boolean isWin = false;
        short inRowH = 0, inRowV = 0;
        short inDiagL1 = 0, inDiagL2 = 0, inDiagR1 = 0, inDiagR2 = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                // check horizontal <->
                if (field[i][j] == dot){
                    inRowH++;
                    if (inRowH == rowToWin) return true;
                }
                else {
                    inRowH = 0;
                }
                // check vertical \/ - /\
                if (field[j][i] == dot){
                    inRowV++;
                    if (inRowV == rowToWin) return true;
                }
                else {
                    inRowV = 0;
                }
            }

            int j = 0;
            while (j + i < fieldSize){
                // check left diag \
                // up 1
                if (field[j][j + i] == dot){
                    inDiagL1++;
                    if (inDiagL1 == rowToWin) return true;
                }
                else {
                    inDiagL1 = 0;
                }

                //down 2
                if (field[j + i][j] == dot){
                    inDiagL2++;
                    if (inDiagL2 == rowToWin) return true;
                }
                else {
                    inDiagL2 = 0;
                }

                // check right diag /
                // up 1
                if (field[j][fieldSize - 1 - j - i] == dot) {
                    inDiagR1++;
                    if (inDiagR1 == rowToWin) return true;
                }
                else {
                    inDiagR1 = 0;
                }

                //down2
                if ((j + i < fieldSize - 1) && (field[j + i + 1][fieldSize - 1 - j] == dot)) {
                    inDiagR2++;
                    if (inDiagR2 == rowToWin) return true;
                }
                else {
                    inDiagR2 = 0;
                }

                j++;
            }

        }
//        for (int i = 0; i < field.length;i++){
//            //if (fieldSize - i >= rowToWin){
//
//            //}
//        }
        return isWin;
    }

    private static boolean isFieldFull(){
        boolean isFull = true;
        for (char[] aField : field) {
            for (int j = 0; j < field.length; j++) {
                if (aField[j] == DOT_EMPTY) isFull = false;
            }
        }
        return isFull;
    }

    private static boolean isCellValid(int row, int col) {
        return (row >= 0 && row < fieldSize) &&
                (col >= 0 && col < fieldSize) &&
                field[row][col] == DOT_EMPTY;
    }
}
