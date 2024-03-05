package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class TransferMoneyExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        String email2 = command_args.get(1);
        String currency = command_args.get(2);
        double amount = Double.parseDouble(command_args.get(3));

        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                if (!user.getFriends().contains(email2)) {
                    System.out.println("You are not allowed to transfer money to " + email2);
                    return;
                }
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals(currency)) {
                        if (account.getBalance() < amount) {
                            System.out.println("Insufficient amount in account " + currency + " for transfer");
                            return;
                        }
                        account.removeMoney(amount);
                    }
                }
            }
        }

        for (User user : Main.users) {
            if (user.getEmail().equals(email2)) {
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals(currency)) {
                        account.addMoney(amount);
                    }
                }
            }
        }
    }
}
