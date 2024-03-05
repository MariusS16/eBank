package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class AddMoneyExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        String currency = command_args.get(1);
        double amount = Double.parseDouble(command_args.get(2));

        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals(currency)) {
                        account.addMoney(amount);
                        return;
                    }
                }
            }
        }
    }
}
