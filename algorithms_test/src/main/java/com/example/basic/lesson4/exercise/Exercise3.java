package com.example.basic.lesson4.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        // 氣泡排序
        int[] numbers = {70, 80, 31, 37, 10, 1, 48, 60, 33, 80};
        boolean flag = true;
        for (int i = 0; i < numbers.length - 1 && flag; i++) {
            flag = false; // 每次外部迴圈開始時，重置標記

            // 內部迴圈，遍歷陣列進行比較和交換
            for (int j = 0; j < numbers.length - i - 1; j++) {
                // 如果後一個元素比前一個元素小，進行交換
                if (numbers[j + 1] < numbers[j]) {
                    // 使用臨時變數 t 來儲存 numbers[j + 1] 的值
                    int t = numbers[j + 1];
                    // 將 numbers[j] 的值賦值給 numbers[j]
                    numbers[j + 1] = numbers[j];
                    // 將臨時變量 t 的值賦值給 numbers[j]
                    numbers[j] = t;
                    // 標記發生交換
                    flag = true;
                }
            }

            // 如果在內部迴圈沒有進行任何的交換，則陣列已經是有序，提前結束排序
            if (!flag) {
                break;
            }
        }

        for (var number : numbers) {
            System.out.printf("%3d", number);
        }
    }

}
