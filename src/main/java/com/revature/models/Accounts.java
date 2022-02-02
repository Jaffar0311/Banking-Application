package com.revature.models;

public class Accounts {
    private User customer;
    private int balance;
    private int accountNumber;

    public Accounts() {
    }

    public Accounts(User customer, int balance, int accountNumber) {
        this.customer = customer;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "customer=" + customer +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
