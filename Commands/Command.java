package org.poo.cb.Commands;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    private static Command instance = null;

    private Command() {
    }

    public static Command getInstance() {
        if (instance == null) {
            instance = new Command();
        }
        return instance;
    }

    public void executeCom(String command) {
        String[] command_split = command.split(" ");
        String command_type = command_split[0] + " " + command_split[1];
        ArrayList<String> command_args = new ArrayList<String>(Arrays.asList(command_split).subList(2, command_split.length));
        if (command_type.equals("CREATE USER")) {
            new CreateUserExecute().execute(command_args);
        }
        if (command_type.equals("ADD FRIEND")) {
            new AddFriendExecute().execute(command_args);
        }
        if (command_type.equals("LIST USER")) {
            new ListUsersExecute().execute(command_args);
        }
        if (command_type.equals("ADD ACCOUNT")) {
            new AddAccountExecute().execute(command_args);
        }
        if (command_type.equals("ADD MONEY")) {
            new AddMoneyExecute().execute(command_args);
        }
        if (command_type.equals("LIST PORTFOLIO")) {
            new ListPortfolioExecute().execute(command_args);
        }
        if (command_type.equals("EXCHANGE MONEY")) {
            new ExchangeMoneyExecute().execute(command_args);
        }
        if (command_type.equals("TRANSFER MONEY")) {
            new TransferMoneyExecute().execute(command_args);
        }
        if (command_type.equals("BUY STOCKS")) {
            new BuyStocksExecute().execute(command_args);
        }
        if (command_type.equals("RECOMMEND STOCKS")) {
            new RecommendStocksExecute().execute(command_args);
        }
        if (command_type.equals("BUY PREMIUM")) {
            new BuyPremiumExecute().execute(command_args);
        }
    }
}
