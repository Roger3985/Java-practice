package com.example.basic.lesson9.example.properties;

public class LoadSystemProps {
    public static void main(String[] args) {
        var props = System.getProperties();
        System.out.println(props.getProperty("username"));
        System.out.println(props.getProperty("password"));
    }
}
