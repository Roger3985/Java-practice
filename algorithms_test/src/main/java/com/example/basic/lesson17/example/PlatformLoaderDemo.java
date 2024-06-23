package com.example.basic.lesson17.example;

public class PlatformLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader platform = PlatformLoaderDemo.class
                .getClassLoader().getParent();
        System.out.println(platform);

        var clz = platform.loadClass("com.example.basic.lesson17.example.module.Some");
        System.out.println(clz.getClassLoader());
    }
}
