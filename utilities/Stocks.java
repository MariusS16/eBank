package org.poo.cb.utilities;

public class Stocks {
    private final String company;
    private int amount;

    public Stocks(String company, int amount) {
        this.company = company;
        this.amount = amount;
    }

    public String getCompany() {
        return this.company;
    }

    public int getAmount() {
        return this.amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

}
