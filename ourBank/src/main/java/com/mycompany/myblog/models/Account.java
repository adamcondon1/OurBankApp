/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Adam Condon (x18392911)
 * @edited Luke Kavanagh (x17520686)
 */
package com.mycompany.myblog.models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

    public enum AccountType {
        CURRENT, SAVINGS
    }

    //data members
    private AccountType accountType;
    private int accountNumber;
    private int sortCode;
    private double currentBalance;
    private List<Transaction> transactions;

    public Account() {
    }

    //constructor
    public Account(AccountType accountType, int accountNumber, int sortCode, double currentBalance, List<Transaction> transactions) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType AccountType) {
        this.accountType = AccountType;
    }

    //getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

//    Prints accounts
    public String printAccount() {
        String str = this.getAccountNumber() + " " + this.getAccountNumber();
        return str;
    }
}