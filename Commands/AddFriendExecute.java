package org.poo.cb.Commands;

import org.poo.cb.Main;
import org.poo.cb.utilities.User;

import java.util.ArrayList;

public class AddFriendExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        String email_user1 = command_args.get(0);
        String email_user2 = command_args.get(1);

        int ok1 = 0;
        int ok2 = 0;

        for (User user : Main.users) {
            if (user.getEmail().equals(email_user1)) {
                ok1 = 1;
                if (user.getFriends().contains(email_user2)) {
                    System.out.println("User with " + email_user2 + " is already a friend");
                    return;
                }
                user.addFriend(email_user2);
            }
            if (user.getEmail().equals(email_user2)) {
                ok2 = 1;
                if (user.getFriends().contains(email_user1)) {
                    System.out.println("User with " + email_user1 + " is already a friend");
                    return;
                }
                user.addFriend(email_user1);
            }
        }

        if (ok1 == 0) {
            System.out.println("User with " + email_user1 + " doesn't exist");
            return;
        }

        if (ok2 == 0) {
            System.out.println("User with " + email_user2 + " doesn't exist");
        }
    }
}
