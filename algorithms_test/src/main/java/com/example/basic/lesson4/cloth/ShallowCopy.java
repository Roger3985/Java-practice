package com.example.basic.lesson4.cloth;

public class ShallowCopy {
    public static void main(String[] args) {
        Clothes[] c1 = {new Clothes("red", 'L'), new Clothes("blue", 'M')};
        var c2 = new Clothes[c1.length];

        for (int i = 0; i < c1.length; i++) {
            // 淺層複製 不管是 System.arraycopy() or Arrays.copyOf()
            // 只將地址複製給新的
            c2[i] = c1[i];
        }

        c1[0].color = "yellow";
        System.out.println(c2[0].color);
    }
}
