package com.example.basic.lesson11.example.lock;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayList<E> {
    private Lock lock = new ReentrantLock(); // 使用 RenntrantLock
    private Object[] elems;
    private int next;

    public ArrayList(int capacity) {
        elems = new Object[capacity];
    }

    public ArrayList() {
        this(16);
    }

    public void add(E elem) {
        lock.lock(); // 進行鎖定
        try {
            if (next == elems.length) {
                elems = Arrays.copyOf(elems, 2 * elems.length);
            }
            elems[next++] = elem;
        } finally {
            lock.unlock(); // 解除鎖定
        }
    }

    public E get(int index) {
        lock.lock();
        try {
            return (E) elems[index];
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return next;
        } finally {
            lock.unlock();
        }
    }
}
