package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.Stocks;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class ListPortfolioExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        int ok = 0;
        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                ok = 1;
                System.out.print("{\"stocks\":[");
                for (Stocks stock : user.getStocks()) {
                    System.out.print("{\"stockName\":\"" + stock.getCompany() + "\",\"amount\":" + stock.getAmount() + "}");
                    if (user.getStocks().indexOf(stock) != user.getStocks().size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.print("],");
                System.out.print("\"accounts\":[");
                for (Account account : user.getAccounts()) {
                    double amount = account.getBalance();
                    String amountString = String.format("%.2f", amount);
                    System.out.print("{\"currencyName\":\"" + account.getCurrency() + "\",\"amount\":\"" + amountString + "\"}");
                    if (user.getAccounts().indexOf(account) != user.getAccounts().size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println("]}");
            }
        }
        if (ok == 0) {
            System.out.println("User with email " + email + " doesn't exist");
        }
    }
}
