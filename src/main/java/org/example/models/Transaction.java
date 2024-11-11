package org.example.models;

import java.util.Date;

public class Transaction {
    private UserAccount from;
    private UserAccount to;
    private double amount;
    private Date date;

    public Transaction(UserAccount from, UserAccount to, double amount, Date date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    public UserAccount getFrom() {
        return from;
    }

    public void setFrom(UserAccount from) {
        this.from = from;
    }

    public UserAccount getTo() {
        return to;
    }

    public void setTo(UserAccount to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
