package com.example.basic.etc;

import java.math.BigDecimal;

public class DecimalDemo {
    public static void main(String[] args) {
        var operand1 = new BigDecimal("1.0");
        var operand2 = new BigDecimal("0.8");
        var result = operand1.subtract(operand2); // 兩數字相減
        System.out.println(result);
    }
}
