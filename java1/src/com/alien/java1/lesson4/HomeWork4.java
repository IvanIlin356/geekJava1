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
    private static final int DOT_WEIGHT = 10;



    private static boolean isUserFirst;
    private static boolean debug;
    private static char[][] field;
    private static short fieldSize, rowToWin;
    private static int row, col;
    private static Map<Character, String> names = new HashMap<>();
    private static int[][] fieldWeight;

    public static void main(String[] args) {
        boolean inGame = true;
        while (inGame) {
            System.out.println("");
            System.out.println("     ==========     ");
            System.out.println("");
            System.out.println("Сыграем в Крестики-Нолики!");

            ticTakToe(true);

            System.out.println("Хотите сыграть еще раз? 1 - Да, 0 - Нет");
            if (scanner.nextInt() == 0)
                inGame = false;
        }
    }

    private static void ticTakToe(boolean isDebug){
        debug = isDebug;
        boolean inGame = true;
        initGame();
        printField();

        do {
            playerTurn();
            printField();
            computerTurn();
        } while (!checkForWin(DOT_X));
    }

    private static void computerTurn() {
        getFieldWeight(DOT_X);
        if (debug) printFieldWeight();
    }

    private static void getFieldWeight(char dot) {
        int jPrev2 = -1, jPrev = -1, jPrevL1 = -1, jPrevL2 = -1, jPrevR1 = -1, jPrevR2 = -1, iPrevL1 = -1, iPrevL2 = -1, iPrevR1 = -1, iPrevR2 = -1;
        int jNext2 = -1, jNext = -1, iNextL1 = -1, iNextL2 = -1, iNextR1 = -1, iNextR2 = -1, jNextL1 = -1, jNextL2 = -1, jNextR1 = -1, jNextR2 = -1;
        int inRowH = 0, inRowV = 0, inRowL1 = 0, inRowL2 = 0, inRowR1 = 0, inRowR2 = 0;

        char antiDot = (dot == DOT_X) ? DOT_O : DOT_X;

        clearFieldWeight();

        for (int i = 0; i < fieldWeight.length; i ++){
            for (int j = 0; j < fieldWeight.length; j ++) {
                // check horizont <->
//                if (field[i][j] == DOT_EMPTY) {
//                    fieldWeight[i][j] += 1;
//                    if (inRowH > 0) {
//                        if (jPrev >= 0) fieldWeight[i][jPrev] += inRowH * DOT_WEIGHT;
//                        if (jNext >= 0) fieldWeight[i][jNext] += inRowH * DOT_WEIGHT;
//                        jPrev = jNext = -1;
//                        inRowH = 0;
//                    }
//                }
//                if (field[i][j] == dot) {
//                    if (jPrev == -1) jPrev = (j > 0 ? (j - 1) : -2);
//                    inRowH++;
//                    jNext = (j < fieldSize - 1) ? (j + 1) : -2;
//
//                }
//
//                // check vertical /\ - \/
//                if (field[j][i] == DOT_EMPTY) {
//                    fieldWeight[j][i] += 1;
//                    if (inRowV > 0) {
//                        if (jPrev2 >= 0) fieldWeight[jPrev2][i] += inRowV * DOT_WEIGHT;
//                        if (jNext2 >= 0) fieldWeight[jNext2][i] += inRowV * DOT_WEIGHT;
//                        jPrev2 = jNext2 = -1;
//                        inRowV = 0;
//                    }
//                }
//                if (field[j][i] == dot) {
//                    if (jPrev2 == -1) jPrev2 = (j > 0 ? (j - 1) : -2);
//                    inRowV++;
//                    jNext2 = (j < fieldSize - 1) ? (j + 1) : -2;
//                }
//
//                if (j == fieldWeight.length - 1){
//                    if (jPrev >= 0) fieldWeight[i][jPrev] += inRowH * DOT_WEIGHT;
//                    if (jNext >= 0) fieldWeight[i][jNext] += inRowH * DOT_WEIGHT;
//                    if (jPrev2 >= 0) fieldWeight[jPrev2][i] += inRowV * DOT_WEIGHT;
//                    if (jNext2 >= 0) fieldWeight[jNext2][i] += inRowV * DOT_WEIGHT;
//                }
            }
            inRowV = 0;
            jPrev2 = jNext2 = -1;
            inRowH = 0;
            jPrev = jNext = -1;



            int j = 0;
            while (j + i < fieldWeight.length){
                // check left diag \
                // up 1
//                if (field[j][j + i] == DOT_EMPTY){
//                    fieldWeight[j][j + i] += 1;
//                    if (inRowL1 > 0) {
//                        if (jPrevL1 >= 0 && iPrevL1 >= 0) fieldWeight[jPrevL1][iPrevL1] += inRowL1 * DOT_WEIGHT;
//                        if (jNextL1 >= 0 && iNextL1 >= 0) fieldWeight[jNextL1][iNextL1] += inRowL1 * DOT_WEIGHT;
//                        iPrevL1 = jPrevL1 = iNextL1 = jNextL1 = -1;
//                        inRowL1 = 0;
//                    }
//                }
//                if (field[j][j + i] == dot){
//                    if (jPrevL1 == -1) jPrevL1 = (j > 0 ? (j - 1) : -2);
//                    if (iPrevL1 == -1) iPrevL1 = (j + i > 0 ? (j + i - 1) : -2);
//                    inRowL1++;
//                    jNextL1 = (j < fieldSize - 1) ? (j + 1) : -2;
//                    iNextL1 = (j + i < fieldSize - 1) ? (j + i + 1) : -2;
//                }
//
//                //down 2
//                if (j + i != j) {
//                    if (field[j + i][j] == DOT_EMPTY) {
//                        fieldWeight[j + i][j] += 1;
//                        if (inRowL2 > 0) {
//                            if (jPrevL2 >= 0 && iPrevL2 >= 0) fieldWeight[jPrevL2][iPrevL2] += inRowL2 * DOT_WEIGHT;
//                            if (jNextL2 >= 0 && iNextL2 >= 0) fieldWeight[jNextL2][iNextL2] += inRowL2 * DOT_WEIGHT;
//                            iPrevL2 = jPrevL2 = iNextL2 = jNextL2 = -1;
//                            inRowL2 = 0;
//                        }
//                    }
//                    if (field[j + i][j] == dot) {
//                        if (jPrevL2 == -1) jPrevL2 = (j + i > 0 ? (j + i - 1) : -2);
//                        if (iPrevL2 == -1) iPrevL2 = (j > 0 ? (j - 1) : -2);
//                        inRowL2++;
//                        jNextL2 = (j + i < fieldSize - 1) ? (j + i + 1) : -2;
//                        iNextL2 = (j < fieldSize - 1) ? (j + 1) : -2;
//                    }
//                }

                // check right diag /
                // up 1
//                if (field[j][fieldSize - 1 - j - i] == DOT_EMPTY) {
//                    fieldWeight[j][fieldSize - 1 - j - i] += 1;
//                    if (inRowR1 > 0){
//                        if (jPrevR1 >= 0 && iPrevR1 >= 0) fieldWeight[jPrevR1][iPrevR1] += inRowR1 * DOT_WEIGHT;
//                        if (jNextR1 >= 0 && iNextR1 >= 0) fieldWeight[jNextR1][iNextR1] += inRowR1 * DOT_WEIGHT;
//                        iPrevR1 = jPrevR1 = iNextR1 = jNextR1 = -1;
//                        inRowR1 = 0;
//                    }
//                }
//                if (field[j][fieldSize - 1 - j - i] == dot) {
//                    if (jPrevR1 == -1) jPrevR1 = (j > 0 ? (j - 1) : -2);
//                    if (iPrevR1 == -1) iPrevR1 = (fieldSize - 1 - j - i > 0 ? (fieldSize - 1 - j - i + 1) : -2);
//                    inRowR1++;
//                    jNextR1 = (j < fieldSize - 1) ? (j + 1) : -2;
//                    iNextR1 = (fieldSize - 1 - j - i < fieldSize - 1) ? (fieldSize - 1 - j - i - 1) : -2;
//                }

                //down2
                // TODO
                //if (((j + i + 1) + (fieldSize - 1 - j) != fieldSize - 1) &&
                        //((j + i < fieldSize - 1))) {
                   // if ((field[j + i + 1][fieldSize - 1 - j] == DOT_EMPTY)) {
                if (j != 0) {
                    if ((field[j + i][fieldSize - j] == DOT_EMPTY)) {
                        fieldWeight[j + i][fieldSize - j] += 1;
                        if (inRowR2 > 0) {
                            if (jPrevR2 >= 0 && iPrevR2 >= 0) fieldWeight[jPrevR2][iPrevR2] += inRowR2 * DOT_WEIGHT;
                            if (jNextR2 >= 0 && iNextR2 >= 0) fieldWeight[jNextR2][iNextR2] += inRowR2 * DOT_WEIGHT;
                            iPrevR2 = jPrevR2 = iNextR2 = jNextR2 = -1;
                            inRowR2 = 0;
                        }
                    }
                    if (field[j + i][fieldSize - j] == dot) {
//                        if (jPrevR2 == -1) jPrevR2 = (j > 0 ? (j - 1) : -2);
//                        if (iPrevR2 == -1) iPrevR2 = (fieldSize - 1 - j - i > 0 ? (fieldSize - 1 - j - i + 1) : -2);
                        if (jPrevR2 == -1) jPrevR2 = (j + i > 0 ? (j + i - 1) : -2);
                        if (iPrevR2 == -1) iPrevR2 = (fieldSize - j > 0 ? (fieldSize - j + 1) : -2);
                        inRowR2++;
                        jNextR2 = (j + i < fieldSize - 1) ? (j + i + 1) : -2;
                        iNextR2 = (fieldSize - j < fieldSize - 1) ? (fieldSize - j - 1) : -2;
                    }
                }
                //}

                if (j + i == fieldWeight.length - 1){
                    if (jPrevL1 >= 0 && iPrevL1 >= 0) fieldWeight[jPrevL1][iPrevL1] += inRowL1 * DOT_WEIGHT;
                    if (jNextL1 >= 0 && iNextL1 >= 0) fieldWeight[jNextL1][iNextL1] += inRowL1 * DOT_WEIGHT;

                    if (jPrevL2 >= 0 && iPrevL2 >= 0) fieldWeight[jPrevL2][iPrevL2] += inRowL2 * DOT_WEIGHT;
                    if (jNextL2 >= 0 && iNextL2 >= 0) fieldWeight[jNextL2][iNextL2] += inRowL2 * DOT_WEIGHT;

                    if (jPrevR1 >= 0 && iPrevR1 >= 0) fieldWeight[jPrevR1][iPrevR1] += inRowR1 * DOT_WEIGHT;
                    if (jNextR1 >= 0 && iNextR1 >= 0) fieldWeight[jNextR1][iNextR1] += inRowR1 * DOT_WEIGHT;

                    if (jPrevR2 >= 0 && iPrevR2 >= 0) fieldWeight[jPrevR2][iPrevR2] += inRowR2 * DOT_WEIGHT;
                    if (jNextR2 >= 0 && iNextR2 >= 0) fieldWeight[jNextR2][iNextR2] += inRowR2 * DOT_WEIGHT;
                }

                j++;
            }
            inRowL1 = inRowL2 = inRowR1 = inRowR2 = 0;

        }
    }

    private static void printFieldWeight(){
        System.out.println("Таблица весов:");
        for (int i = 0; i < fieldWeight.length; i++) {
            for (int j = 0; j < fieldWeight.length; j++){
                System.out.print(fieldWeight[i][j] + "\t");
            }
            System.out.println();
        }
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

        fieldWeight = new int[fieldSize][fieldSize];

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

            inRowH = inRowV = 0;

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
            inDiagL1 = inDiagL2 = inDiagR1 = inDiagR2 = 0;

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

    private static void clearFieldWeight(){
        for (int i = 0; i < fieldWeight.length; i ++){
            for (int j = 0; j < fieldWeight.length; j ++){
                fieldWeight[i][j] = 0;
            }
        }
    }
}
