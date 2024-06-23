package com.example.basic.lesson17.example;

public class ProxyDemo {
    public static void main(String[] args) {
        var helloProxy = (Hello) LoggingProxy.bind(new HelloSpeaker());
        helloProxy.hello("Justin");
    }
}
