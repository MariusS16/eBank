package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class ListUsersExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email = command_args.get(0);
        int ok = 0;
        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                ok = 1;
                System.out.print("{\"email\":\"" + user.getEmail() + "\",\"firstname\":\"" + user.getPrenume() + "\",\"lastname\":\"" + user.getNume() + "\",\"address\":\"" + user.getAddress() + "\",\"friends\":[");
                for (String friend : user.getFriends()) {
                    System.out.print("\"" + friend + "\"");
                    if (user.getFriends().indexOf(friend) != user.getFriends().size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println("]}");
                return;
            }
        }
        if (ok == 0) {
            System.out.println("User with " + email + " doesn't exist");
        }
    }
}
