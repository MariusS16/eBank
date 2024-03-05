package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.User;

import java.util.ArrayList;
import java.util.Arrays;

public class ExchangeMoneyExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        String source_currency = command_args.get(1);
        String destination_currency = command_args.get(2);
        double amount = Double.parseDouble(command_args.get(3));

        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals(source_currency)) {
                        if (account.getBalance() < amount) {
                            System.out.println("Insufficient amount in account " + source_currency + " for exchange");
                            return;
                        }
                        String[] header = Main.exchange_rate.get(0).split(",");
                        int indexJ = Arrays.asList(header).indexOf(source_currency);
                        int indexI = 0;
                        for (int i = 1; i < Main.exchange_rate.size(); i++) {
                            String currency = Main.exchange_rate.get(i).split(",")[0];
                            if (currency.equals(destination_currency)) {
                                indexI = i;
                                break;
                            }
                        }
                        double exchange_rate = Double.parseDouble(Main.exchange_rate.get(indexI).split(",")[indexJ]);
                        double commission = 0;
                        if (!user.getPremium()) {
                            if (account.getBalance() / 2 < amount * exchange_rate) {
                                commission = 0.01 * amount * exchange_rate;
                            }
                        }
                        account.removeMoney(amount * exchange_rate + commission);
                    }
                    if (account.getCurrency().equals(destination_currency)) {
                        account.addMoney(amount);
                    }
                }
            }
        }
    }
}
