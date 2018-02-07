package com.alien.java1.lesson5;

import java.util.Random;
import java.util.Scanner;

public class HomeWork5 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

    private static String inputName, inputPosition, inputEmail, inputPhone;
    private static int inputAge, inputSalary;

    public static void main(String[] args) {
        System.out.println("Работа с классом сотрудник");
        System.out.print("Введите размер массива: ");
        int empArraySize = scanner.nextInt();
        Employee[] employees = new Employee[empArraySize];
        System.out.println("Введите 1 чтобы заполнить массив вручную");
        System.out.println("Введите 2 чтобы сгенерировать массив автоматически");
        switch (scanner.nextInt()){
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    System.out.println("Сотрудник №" + (i + 1));
                    System.out.print("Введите имя: ");
                    inputName = scanner.next();
                    System.out.print("Введите должность: ");
                    inputPosition = scanner.next();
                    System.out.print("Введите email: ");
                    inputEmail = scanner.next();
                    System.out.print("Введите телефон: ");
                    inputPhone = scanner.next();
                    System.out.print("Введите зарплату: ");
                    inputSalary = scanner.nextInt();
                    System.out.print("Введите возраст: ");
                    inputAge = scanner.nextInt();

                    employees[i] = new Employee(inputName, inputPosition, inputEmail, inputPhone, inputSalary, inputAge);
                }
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    employees[i] = new Employee();
                }
                break;
        }
        System.out.println();
        System.out.println(" ===== Список всех сотрудников ===== ");
        for (int i = 0; i < employees.length; i++) {
            employees[i].printEmployee();
            System.out.println();
        }

        System.out.println(" ===== Список всех сотрудников старше 40 ===== ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) {
                employees[i].printEmployee();
                System.out.println();
            }
        }
    }
}
