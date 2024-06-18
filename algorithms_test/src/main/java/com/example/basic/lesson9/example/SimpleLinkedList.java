package com.example.basic.lesson9.example;

public class SimpleLinkedList {
    
    /**
     * 將收集的物件用 Node 封裝
     */
    private class Node {
        Node(Object o) {
            this.o = o;
        }
        Object o;
        Node next;
    }

    private Node first; // 第一個節點

    /**
     * 新增 Node 封裝物件，並將由上個 Node 的 next 參考
     */
    public void add(Object elem) {
        var node = new Node(elem);
        if (first == null) {
            first = node;
        }
        else {
            append(node);
        }
    }

    private void append(Node node) {
        var last = first;
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
    }

    /**
     * 走訪所有 Node 並計數以取得長度
     */
    public int size() {
        var count = 0;
        var last = first;
        while(last != null) {
            last = last.next;
            count++;
        }
        return count;
    }

    public Object get(int index) {
        checkSize(index);
        return findElemOf(index);
    }

    private void checkSize(int index) {
        var size = size();
        if (index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: %d, Size: %d".formatted(index, size));
        }
    }

    /**
     * 走訪所有 Node 並計數以取得對應索引物件
     */
    private Object findElemOf(int index) {
        var count = 0;
        var last = first;
        while(count < index) {
            last = last.next;
            count++;
        }
        return last.o;
    }
}
