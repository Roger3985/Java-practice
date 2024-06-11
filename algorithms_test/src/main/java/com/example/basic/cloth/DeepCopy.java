package com.example.basic.cloth;

public class DeepCopy {
    public static void main(String[] args) {
        Clothes2[] c1 = {new Clothes2("red", 'L'), new Clothes2("blue", 'M')};
        var c2 = new Clothes2[c1.length];

        for (int i = 0; i < c1.length; i++) {
            c2[i] = new Clothes2(c1[i].color, c1[i].size); // <- 自行複製元素
        }

        c1[0].color = "yellow";
        System.out.println(c2[0].color);
    }
}
