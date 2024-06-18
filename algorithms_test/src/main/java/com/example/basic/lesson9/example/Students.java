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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!number.equals(other.number)) {
            return false;
        }
        return true;
    }
}
public class Students {
    public static void main(String[] args) {
        var students = new HashSet();
        students.add(new Student("John", "123"));
        students.add(new Student("Jane", "456"));
        students.add(new Student("John", "123"));
        System.out.println(students);
    }
}
