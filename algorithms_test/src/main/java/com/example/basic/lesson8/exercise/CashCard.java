package com.example.basic.lesson8.exercise;

public class CashCard {
    private String number;
    private int balance;
    private int bonus;

    public CashCard(String number, int balance, int bonus) {
        this.number = number;
        this.balance = balance;
        this.bonus = bonus;
    }

    public void store(int money) {
        checkGreaterThanZero(money, "儲值是負的？你是來亂的嗎？");

        this.balance += money;
        if (money >= 1000) {
            this.bonus++;
        }
    }

    public void charge(int money) {
        checkGreaterThanZero(money, "扣負數？這不是叫我儲值嗎？");

        if (money <= this.balance) {
            this.balance -= money;
        } else {
            System.out.println("錢不夠啦！");
        }
    }

    private void checkGreaterThanZero(int money, String msg) {
        if (money < 0) {
            throw new IllegalArgumentException(msg);
        }
    }

    public int exchange(int bonus) {
        checkGreaterThanZero(bonus, "負的點數？想偷儲存點數啊！");

        this.bonus -= bonus;
        return this.bonus;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
