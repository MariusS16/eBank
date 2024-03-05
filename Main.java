package org.poo.cb;

import org.poo.cb.Commands.Command;
import org.poo.cb.utilities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<String> stock_values = new ArrayList<String>();
    public static ArrayList<String> exchange_rate = new ArrayList<String>();

    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Running Main");
            return;
        }

        String path_resources = "src/main/resources/";
        String path_stock_values = path_resources + args[1];
        String path_exchange_rate = path_resources + args[0];
        String path_commands = path_resources + args[2];

        ArrayList<String> command = new ArrayList<String>();
        users = new ArrayList<>();
        stock_values = new ArrayList<String>();
        exchange_rate = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(path_commands))) {
            String line;
            while ((line = br.readLine()) != null) {
                command.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path_stock_values))) {
            String line;
            while ((line = br.readLine()) != null) {
                stock_values.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path_exchange_rate))) {
            String line;
            while ((line = br.readLine()) != null) {
                exchange_rate.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Command commandInstance = Command.getInstance();
        for (String com : command) {
            commandInstance.executeCom(com);
        }
    }
}