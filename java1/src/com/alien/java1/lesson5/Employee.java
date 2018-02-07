package com.alien.java1.lesson5;

import java.util.Random;

public class Employee {
    private static Random rnd = new Random();

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    String[] names = {"Василий", "Петр", "Иван", "Александр", "Кирилл", "Дарья", "Мария", "Александра", "Василиса", "Юлия"};
    String[] positions = {"Программист", "Инженер", "Архитектор", "Бухгалтер", "Юрист", "Исследователь", "Уборщик", "Водитель", "Грузчик", "Директор"};
    String[] emails = {"aaa@gmail.com", "bbb@gmail.com", "ccc@gmail.com", "ddd@gmail.com", "eee@gmail.com", "fff@gmail.com", "ggg@gmail.com", "hhh@gmail.com", "jjj@gmail.com", "kkk@gmail.com"};
    String[] phones = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};

    public Employee(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(){
        this.name = names[rnd.nextInt(10)];
        this.position = positions[rnd.nextInt(10)];
        this.email= emails[rnd.nextInt(10)];
        this.phone = phones[rnd.nextInt(10)];
        this.salary = rnd.nextInt(100000000);
        this.age = rnd.nextInt(100);
    }

    public void printEmployee(){
        System.out.println("Сотрудник: " + name + " (" + position + "), возраст: " + age);
        System.out.println("Зарплата: " + salary + "р / мес");
        System.out.println("Контакты:" + phone + ", " + email);
    }

    public int getAge() {
        return age;
    }
}
