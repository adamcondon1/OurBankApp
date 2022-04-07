/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Condon (x18392911)
 * @edited Almoruf Opere(x19117931)
 * @edited Keith Mahony(x17521139)
 * 
 */
@XmlRootElement
public class Customer {

    //data members
    private int customerID;
    private String name;
    private String address;
    private String email;
    private String password;
    private List<Account> accounts;

    public Customer() {
    }

    // constructor
    public Customer(int customerID, String name, String address, String email, String password, List<Account> accounts) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
    }

    //get/set
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

//    Add new account to customer
    public void addAccountToCustomer(Account account) {
        (this.accounts).add(account);
    }

//    Print Customer Details
    public String printCustomer() {
        String str = this.getName() + " " + this.getEmail();
        return str;
    }

//    Prints all accounts
    public String printAllAccounts() {
        String allcom = "";
        for (int i = 0; i < accounts.size(); i++) {
            allcom = allcom + accounts.get(i).printAccount() + " ";
        }
        return allcom;
    }
}
