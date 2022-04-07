/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.services;

import com.mycompany.myblog.models.Account;
import com.mycompany.myblog.models.Customer;
import com.mycompany.myblog.models.Transaction;
import com.mycompany.ourbank.database.Database;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 * 
 * @author Keith Mahony (x17521139)
 * @edited Luke Kavanagh (x17520686) - Lodgements 
 * 
 */


public class TransactionService {

    private List<Customer> cList = Database.getCustomerList();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public List<Transaction> getTransactions(int cid, int aid) {
        List<Account> accountList = cList.get(cid - 1).getAccounts();
        for (Account account : accountList) {
            if (account.getAccountNumber() == aid) {
                return account.getTransactions();
            } else {
                System.out.println("There is no customers with this account number.");
                return null;
            }
        }
        return null;
    }

    // Handle Lodge Transactions
    public Transaction makeLodgement(int cid, int aid, Transaction t) {
        LocalDateTime now = LocalDateTime.now();
        t.setTransactionDate(dtf.format(now));
        List<Account> tmpList = cList.get(cid - 1).getAccounts();
        if(tmpList.size()<=0){
            System.out.println("No accounts found");
            t.setDescription("No accounts found for this customer.");
                return t;
        }
        else{
            for (Account account : tmpList) {
            if (account.getAccountNumber() == aid) {
                double newBalance = account.getCurrentBalance() + t.getAmount();
                account.setCurrentBalance(newBalance);
                t.setModifier("CREDIT");
                account.getTransactions().add(t);
                t.setPostBalance(newBalance);
                t.setRecipient(aid);
                t.setSuccess(true);
                return t;
            } else {
                System.out.println("There is no customers with this account number.");
            }
        }
        }
        return null;
    }

    // Handle Withdraw Transactions 
    public Transaction makeWithdrawal(int cID, int aID, Transaction t) {
        LocalDateTime now = LocalDateTime.now();
        t.setTransactionDate(dtf.format(now));
        List<Account> customerAccounts = cList.get(cID - 1).getAccounts();
        for (Account account : customerAccounts) {
            if (account.getAccountNumber() == aID) {
                if (account.getCurrentBalance() - t.getAmount() < 0) {
                    t.setModifier("DEBIT");
                    account.getTransactions().add(t);
                    t.setDescription("ERROR: Balance too low to complete this transaction.");
                    return t;
                } else {
                    double newBalance = account.getCurrentBalance() - t.getAmount();
                    account.setCurrentBalance(newBalance);
                    t.setModifier("DEBIT");
                    account.getTransactions().add(t);
                    t.setPostBalance(newBalance);
                    t.setSuccess(true);
                    return t;
                }
            } else {
                System.out.println("There is no customers with this account number.");
            }
        }
        return null;
    }

//    Handle Transfer Transactions
    public Transaction makeTransfer(int cid, int aid, int recipientCustomerId, int recipientAccountId, Transaction t) {
        double balance = 0;
        List<Account> customerAccounts = cList.get(cid - 1).getAccounts();
        for (Account account : customerAccounts) {
            if (account.getAccountNumber() == aid) {
                balance = account.getCurrentBalance();
            }
        }
        Transaction withdrawal = makeWithdrawal(cid, aid, t);
        if (withdrawal.isSuccess()) {
            balance = balance - withdrawal.getAmount();
            Transaction lodgement = makeLodgement(recipientCustomerId, recipientAccountId, t);           
            if (lodgement.isSuccess()) {
                t.setPostBalance(balance);
                t.setSuccess(true);
                return t;
            } else {
                t.setPostBalance(balance);
                t.setDescription("Transfer could not be made to this account.");
                return t;
            }         
        } else {
            t.setPostBalance(balance);
            t.setDescription("There was an issue making a transfer from this account.");
            return t;
        }
    }
}
