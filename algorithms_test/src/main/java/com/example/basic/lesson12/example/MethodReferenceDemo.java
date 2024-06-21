package com.example.basic.lesson12.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.System.out;

record Person(String name) {}

public class MethodReferenceDemo {
    static <P, R> List<R> map(List<P> list, Function<P, R> mapper) {
        var mapped = new ArrayList<R>();
        for (var i = 0; i < list.size(); i++) {
            mapped.add(mapper.apply(list.get(i)));
        }
        return mapped;
    }

    public static void main(String[] args) {
        var names = List.of(args);
        var persons = map(names, Person::new);
        persons.forEach(out::println);
    }
}
