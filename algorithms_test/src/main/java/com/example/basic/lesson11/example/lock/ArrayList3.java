package com.example.basic.lesson11.example.lock;

import java.util.Arrays;
import java.util.concurrent.locks.StampedLock;

public class ArrayList3<E> {
    private StampedLock lock = new StampedLock(); // 使用 StampedLock()
    private Object[] elems;
    private int next;

    public ArrayList3(int capacity) {
        elems = new Object[capacity];
    }

    public ArrayList3() {
        this(16);
    }

    public void add(E elem) {
        var stamp =  lock.writeLock(); // 取得寫入鎖定
        try {
            if (next == elems.length) {
                elems = Arrays.copyOf(elems, 2 * elems.length);
            }
            elems[next++] = elem;
        } finally {
            lock.unlockWrite(stamp); // 解除寫入鎖定
        }
    }

    public E get(int index) {
        var stamp = lock.tryOptimisticRead(); // 試著樂觀鎖讀取鎖定
        var elem = elems[index];
        if (!lock.validate(stamp)) { // 查詢是否有排他的鎖定
            stamp = lock.readLock();
            try {
                elem = elems[index];
            } finally {
                lock.unlockRead(stamp); // 解除讀取鎖定
            }
        }
        return (E) elem;
    }

    public int size() {
        var stamp = lock.tryOptimisticRead();
        var size = next;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                size = next;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return size;
    }
}
