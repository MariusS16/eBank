package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class CreateUserExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                System.out.println("User with " + email + " already exists");
                return;
            }
        }

        String address = "";
        for (int i = 3; i < command_args.size(); i++) {
            address += command_args.get(i);
            if (i != command_args.size() - 1) {
                address += " ";
            }
        }
        User user = new User.UserBuilder()
                .setEmail(command_args.get(0))
                .setNume(command_args.get(2))
                .setPrenume(command_args.get(1))
                .setAddress(address)
                .build();

        Main.users.add(user);
    }
}
