package com.example.basic.lesson18.example.Enum;

public enum Priority {
    MAX(10), NORM(5), MIN(1); // 呼叫 enum 建構式

    private int value;

    private Priority(int value) { // 不為 public 的建構式
        this.value = value;
    }

    public int value() {  // 自定義方法
        return value;
    }

    public static void main(String[] args) {
        for (var priority : Priority.values()) {
            System.out.printf("Priority(%s, %d)%n",
                    priority, priority.value);
        }
    }
}
