package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.Stocks;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class BuyStocksExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        String stock_name = command_args.get(1);
        int quantity = Integer.parseInt(command_args.get(2));

        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals("USD")) {
                        double price = 0;
                        for (String stock : Main.stock_values) {
                            String[] stock_split = stock.split(",");
                            if (stock_split[0].equals(stock_name)) {
                                price = Double.parseDouble(stock_split[10]);
                            }
                        }
                        if (account.getBalance() < price * quantity) {
                            System.out.println("Insufficient amount in account for buying stock");
                            return;
                        }
                        if (user.getPremium()) {
                            account.removeMoney(price * 0.95 * quantity);
                        } else {
                            account.removeMoney(price * quantity);
                        }
                    }
                }
                for (Stocks stock : user.getStocks()) {
                    if (stock.getCompany().equals(stock_name)) {
                        stock.addAmount(quantity);
                        return;
                    }
                }
                Stocks new_stock = new Stocks(stock_name, quantity);
                user.getStocks().add(new_stock);
            }
        }
    }
}
