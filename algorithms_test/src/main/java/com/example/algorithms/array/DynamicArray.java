package com.example.algorithms.array;

import java.util.function.Consumer;

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
        if (index >= 0 && index < size) {
            System.arraycopy(array, index,
                    array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 查詢元素
     * @param index 索引位置，在 [0..size) 區間內
     * @return 該索引位置的元素
     */
    public int get(int index) { // [0...size)
        return array[index];
    }

    /**
     * 遍歷方法一。
     * @param consumer 遍歷要執行的操作，放入參數，每個元素。
     */
    public void forEach(Consumer<Integer> consumer) { // 函數式介面寫法
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);

        }
    }
}
