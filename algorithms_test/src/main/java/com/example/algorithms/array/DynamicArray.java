package com.example.algorithms.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 動態陣列實現
 */
public class DynamicArray implements Iterable<Integer> {
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
    public void foreach(Consumer<Integer> consumer) { // 函數式介面寫法
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);

        }
    }

    /**
     * 以下為匿名內部類寫法
     * 遍歷方式二：迭代器遍歷
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 有沒有下一個元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回當前的元素，並且移動到下一個元素
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
