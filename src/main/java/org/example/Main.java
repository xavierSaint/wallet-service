package org.example;

import org.example.service.WalletService;
import org.example.service.WalletServiceInteface;

public class Main {
    public static void main(String[] args) {

        WalletServiceInteface walletServiceInteface = new WalletService();
        walletServiceInteface.createWallet("Harry", 100);
        walletServiceInteface.createWallet("Ron", 95.7);
        walletServiceInteface.createWallet("Hermione", 104);
        walletServiceInteface.createWallet("Albus", 200);
        walletServiceInteface.createWallet("Draco", 500);

        walletServiceInteface.getOverview();

        walletServiceInteface.transferMoney(walletServiceInteface.getUserAccountFromName("Albus"),
                walletServiceInteface.getUserAccountFromName("Draco"), 30);
        walletServiceInteface.transferMoney(walletServiceInteface.getUserAccountFromName("Hermione"),
                walletServiceInteface.getUserAccountFromName("Harry"), 2);
        walletServiceInteface.transferMoney(walletServiceInteface.getUserAccountFromName("Albus"),
                walletServiceInteface.getUserAccountFromName("Ron"), 5);

        walletServiceInteface.getOverview();

        walletServiceInteface.getStatement(walletServiceInteface.getUserAccountFromName("Harry"));
        walletServiceInteface.getStatement(walletServiceInteface.getUserAccountFromName("Albus"));

        walletServiceInteface.getOverview();
        walletServiceInteface.applyOfferTwo();
        walletServiceInteface.getOverview();
    }
}