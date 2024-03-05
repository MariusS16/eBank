package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.Account;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class BuyPremiumExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        int ok = 0;

        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                ok = 1;
                for (Account account : user.getAccounts()) {
                    if (account.getCurrency().equals("USD")) {
                        if (account.getBalance() < 100) {
                            System.out.println("Insufficient amount in account for buying premium option");
                            return;
                        }
                        account.removeMoney(100);
                        user.setPremium();
                        return;
                    }
                }
                break;
            }
        }
        if (ok == 0) {
            System.out.println("User with " + email + " doesn't exist");
        }
    }
}
