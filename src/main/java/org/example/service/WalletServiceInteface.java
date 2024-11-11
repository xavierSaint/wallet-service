package org.example.service;

import org.example.models.UserAccount;

import java.util.Optional;

public interface WalletServiceInteface {

    void createWallet(String name, double amount);
    void transferMoney(Optional<UserAccount> from, Optional<UserAccount> to, double amount);
    void getOverview();
    void getStatement(Optional<UserAccount> user);
    void applyOfferTwo();
    Optional<UserAccount> getUserAccountFromName(String name);
}
