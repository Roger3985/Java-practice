package com.example.algorithms.array;

/**
 * 動態陣列實現
 */
public class DynamicArray {
    private int size = 0; // 邏輯大小
    private int capacity = 8; // 容量
    private int[] array = new int[capacity];

    /**
     * 往最後面 [size]加上元素
     * element - 待添加的元素
     */
    public void addLast(int element) {
        // array[size] = element;
        // size++;
        add(size, element); // add 合併 addLast
    }

    /**
     * 往後面加上元素
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            System.arraycopy(array, index,
                    array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    public int get(int index) { // [0...size)
        return array[index];
    }
}
