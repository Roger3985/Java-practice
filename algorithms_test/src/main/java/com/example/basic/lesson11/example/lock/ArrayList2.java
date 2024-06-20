package com.example.basic.lesson11.example.lock;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayList2<E> {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object[] elems;
    private int next;

    public ArrayList2(int capacity) {
        elems = new Object[capacity];
    }

    public ArrayList2() {
        this(16);
    }

    public void add(E elem) {
        lock.writeLock().lock(); // 取得寫入鎖定
        try {
            if (next == elems.length) {
                elems = Arrays.copyOf(elems, elems.length * 2);
            }
            elems[next++] = elem;
        } finally {
            lock.writeLock().unlock(); // 解除寫入鎖定
        }
    }

    public E get(int index) {
        lock.readLock().lock();
        try {
            return (E) elems[index];
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock(); // 取得讀取鎖定
        try {
            return next;
        } finally {
            lock.readLock().unlock(); // 解除讀取鎖定
        }
    }
}
