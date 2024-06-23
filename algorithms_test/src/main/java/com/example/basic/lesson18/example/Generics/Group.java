package com.example.basic.lesson18.example.Generics;

import java.util.Arrays;
import java.util.Comparator;

public class Group<T> {
    public T[] things;

    public Group(T... things) {
        this.things = things;
    }

    public void sort(Comparator<? super T> comparator) { // 利用 super 宣告，達成類似逆變性的效果
        Arrays.sort(things, comparator);
    }
}
