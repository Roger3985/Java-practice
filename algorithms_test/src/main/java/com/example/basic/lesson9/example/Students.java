package com.example.basic.lesson9.example;

import java.util.*;

class Student {
    private final String name;
    private final String number;

    Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    String name() {
        return this.name;
    }

    String number() {
        return this.number;
    }

    @Override
    public String toString() {
        return "(%s, %s)".formatted(name, number);
    }
}
public class Students {
    public static void main(String[] args) {
        var students = new HashSet();
        students.add(new Student("John", "123"));
        students.add(new Student("Jane", "456"));
        students.add(new Student("Jack", "789"));
        System.out.println(students);
    }
}
