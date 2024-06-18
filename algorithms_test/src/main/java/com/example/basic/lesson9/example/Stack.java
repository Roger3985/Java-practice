package com.example.basic.lesson9.example;

import java.util.*;
import static java.lang.System.out;

public class Stack {
    private Deque elems = new ArrayDeque();
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(Object elem) {
        if (isFull()) {
            return false;
        }
        return elems.offerFirst(elem);
    }

    private boolean isFull() {
        return elems.size() + 1 > capacity;
    }

    public Object pop() {
        return elems.pollLast();
    }

    public Object peek() {
        return elems.peekLast();
    }

    public int size() {
        return elems.size();
    }

    public static void main(String[] args) {
        var stack = new Stack(5);
        stack.push("Justin");
        stack.push("James");
        stack.push("John");
        out.println(stack.pop());
        out.println(stack.pop());
        out.println(stack.pop());
    }
}
