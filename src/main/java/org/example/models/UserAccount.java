package org.example.models;

import java.util.Date;
import java.util.List;

public class UserAccount {
    private int id;
    private String  name;
    private double balance;
    private List<Transaction> transactions;
    private Date accountCreationDate;
    private int transactionCount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public UserAccount(int id, String name, double balance, List<Transaction> transactions, Date accountCreationDate) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.transactions = transactions;
        this.accountCreationDate = accountCreationDate;
        this.transactionCount= 0;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
}
