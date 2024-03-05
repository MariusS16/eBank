package org.poo.cb.utilities;

import java.util.ArrayList;

public class User {
    private final ArrayList<String> friends;
    private final String email;
    private final String nume;
    private final String prenume;
    private final String address;
    private final ArrayList<Account> accounts;
    private final ArrayList<Stocks> stocks;
    private Boolean premium;


    public User(UserBuilder builder) {
        this.email = builder.email;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
        this.address = builder.address;
        this.friends = new ArrayList<String>();
        this.accounts = new ArrayList<Account>();
        this.stocks = new ArrayList<Stocks>();
        this.premium = false;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<String> getFriends() {
        return this.friends;
    }

    public void addFriend(String email) {
        this.friends.add(email);
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public ArrayList<Stocks> getStocks() {
        return this.stocks;
    }

    public void setPremium() {
        this.premium = true;
    }

    public Boolean getPremium() {
        return this.premium;
    }


    public static class UserBuilder {
        private String email;
        private String nume;
        private String prenume;
        private String address;

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setNume(String nume) {
            this.nume = nume;
            return this;
        }

        public UserBuilder setPrenume(String prenume) {
            this.prenume = prenume;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
