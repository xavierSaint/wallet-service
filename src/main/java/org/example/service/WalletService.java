package org.example.service;

import org.example.models.Transaction;
import org.example.models.UserAccount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class WalletService implements WalletServiceInteface {

    UserAccount superUserAccount = new UserAccount(0, "Offer1", 1000000000, new ArrayList<>(), new Date());
    Optional<UserAccount> superUserAccount1 = Optional.of(new UserAccount(Integer.MAX_VALUE, "Offer2", 1000000000, new ArrayList<>(), new Date()));
    List<UserAccount> userAccountsList = new ArrayList<>();


    @Override
    public void createWallet(String name, double amount) {
        if(amount<0){
            System.out.println("User balance can't be less than 0");
        }
        UserAccount userAccount = new UserAccount(userAccountsList.size()+1,name, amount, new ArrayList<>(), new Date());
        userAccountsList.add(userAccount);
    }



    @Override
    public void transferMoney(Optional<UserAccount> from, Optional<UserAccount> to, double amount) {
        if (from.isEmpty() || to.isEmpty()) {
            System.out.println("Error: User doesn't exist with the given names");
            return;
        }
        from.get().setBalance(from.get().getBalance() - amount);
        to.get().setBalance(to.get().getBalance() + amount);

        //increment transaction count
        from.get().setTransactionCount(from.get().getTransactionCount() + 1);
        to.get().setTransactionCount(to.get().getTransactionCount() + 1);

        //updating the transactions for both sender and receiver
        from.get().getTransactions().add(new Transaction(from.get(), to.get(), amount, new Date()));
        to.get().getTransactions().add(new Transaction(from.get(), to.get(), amount, new Date()));

        //offer 1
        if (from.get().getBalance() == (to.get().getBalance())){
            from.get().setBalance(from.get().getBalance() + 10.0);
            to.get().setBalance(to.get().getBalance() + 10.0);

            //updating the transactions for both sender and receiver
            from.get().getTransactions().add(new Transaction(superUserAccount, from.get(), 10, new Date()));
            to.get().getTransactions().add(new Transaction(superUserAccount, to.get(), 10, new Date()));
        }
    }

    @Override
    public void getOverview() {
        for (UserAccount userAccounts : userAccountsList) {
            System.out.println(userAccounts.getName()+" "+userAccounts.getBalance());
        }
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public void getStatement(Optional<UserAccount> user) {
        if (user.isEmpty()) {
            System.out.println("Error: User doesn't exist with the given name");
            return;
        }
        for (Transaction transaction : user.get().getTransactions()) {
            UserAccount from = transaction.getFrom();
            UserAccount to = transaction.getTo();
            if (user.get().equals(from)) {
                System.out.println(to.getName()+" debit "+ transaction.getAmount());
            } else if(user.get().equals(to)) {
                System.out.println(from.getName()+" credit "+ transaction.getAmount());
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public void applyOfferTwo() {
        //no of transactions --> getStatement (exclude any offers)
        userAccountsList.sort((o1, o2) ->
        {
            if (o2.getTransactionCount() == o1.getTransactionCount()) {
                if (o2.getBalance() == o1.getBalance()) {
                    return o2.getAccountCreationDate().compareTo(o1.getAccountCreationDate());
                }
                return (int) (o2.getBalance() - o1.getBalance());
            }
            return o2.getTransactionCount() - o1.getTransactionCount();
        });

        UserAccount userAccount1 = userAccountsList.get(0);
        UserAccount userAccount2 = userAccountsList.get(1);
        UserAccount userAccount3 = userAccountsList.get(2);

        transferMoney(superUserAccount1, Optional.ofNullable(userAccount1), 10);
        transferMoney(superUserAccount1, Optional.ofNullable(userAccount2), 5);
        transferMoney(superUserAccount1, Optional.ofNullable(userAccount3), 2);

    }

    @Override
    public Optional<UserAccount> getUserAccountFromName(String name) {
       return userAccountsList.stream().filter(user -> user.getName().equals(name)).findFirst();
    }
}
