package org.poo.cb.Commands;

import org.poo.cb.Main;

import java.util.ArrayList;

public class RecommendStocksExecute extends CommandExecute {
    @Override
    public void execute(ArrayList<String> command_args) {
        ArrayList<String> stocksRecommended = new ArrayList<String>();
        for (String stock : Main.stock_values) {
            if (Main.stock_values.indexOf(stock) == 0) {
                continue;
            }
            double stock10 = 0;
            double stock5 = 0;
            String[] stock_split = stock.split(",");
            for (int i = 1; i < stock_split.length; i++) {
                stock10 += Double.parseDouble(stock_split[i]);
            }
            for (int i = 6; i < stock_split.length; i++) {
                stock5 += Double.parseDouble(stock_split[i]);
            }
            if (stock5 / 5 > stock10 / 10) {
                stocksRecommended.add(stock_split[0]);
            }
        }
        System.out.print("{\"stockstobuy\":[");
        for (int i = 0; i < stocksRecommended.size(); i++) {
            if (i == stocksRecommended.size() - 1) {
                System.out.print("\"" + stocksRecommended.get(i) + "\"");
            } else {
                System.out.print("\"" + stocksRecommended.get(i) + "\",");
            }
        }
        System.out.println("]}");
    }
}
