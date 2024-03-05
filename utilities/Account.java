package org.poo.cb.utilities;

public class Account {
    private final String currency;
    private double balance;

    public Account(String currency) {
        this.currency = currency;
        this.balance = 0;
    }

    public String getCurrency() {
        return this.currency;
    }

    public double getBalance() {
        return this.balance;
    }

    public void addMoney(double amount) {
        this.balance += amount;
    }

    public void removeMoney(double amount) {
        this.balance -= amount;
    }
}
