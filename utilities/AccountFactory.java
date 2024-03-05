package org.poo.cb.utilities;

public class AccountFactory {
    public static Account createAccount(String accountType) {
        if (accountType.equals("EUR")) {
            return new EurAccount();
        } else if (accountType.equals("GBP")) {
            return new GbpAccount();
        } else if (accountType.equals("USD")) {
            return new UsdAccount();
        } else if (accountType.equals("CAD")) {
            return new CadAccount();
        } else if (accountType.equals("JPY")) {
            return new JpyAccount();
        }
        return null;
    }
}
