/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ourbank.database;

import com.mycompany.myblog.models.Account;
import com.mycompany.myblog.models.Account.AccountType;
import com.mycompany.myblog.models.Customer;
import com.mycompany.myblog.models.Transaction;
import com.mycompany.myblog.models.Transaction.TransactionType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Almoruf Opere(x19117931)
 * @edited Keith Mahony (x17521139) - added real-time dates of transactions
 * 
 */
public class Database {

    private static List<Customer> customerList = new ArrayList<>();
    private static List<Account> ac1 = new ArrayList<>();
    private static List<Account> ac2 = new ArrayList<>();
    private static List<Account> ac3 = new ArrayList<>();
    private static List<Account> ac4 = new ArrayList<>();
    private static List<Account> ac5 = new ArrayList<>();
    private static List<Transaction> a1Transactions = new ArrayList<>();
    private static List<Transaction> a2Transactions = new ArrayList<>();
    private static List<Transaction> a3Transactions = new ArrayList<>();
    private static List<Transaction> a4Transactions = new ArrayList<>();
    private static List<Transaction> a5Transactions = new ArrayList<>();
    //boolean set to true, will be set to false once database is instantiated
    private static boolean init = true;

    public Database() {
            
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();

        // seed mthods
        if (init) {

            //seed for customer details
            Transaction t1 = new Transaction(TransactionType.LODGEMENT, 75.08, dtf.format(now), "Opening account", 75.080);
            Transaction t2 = new Transaction(TransactionType.LODGEMENT, 105.10, dtf.format(now), "Opening account", 105.10);
            Transaction t3 = new Transaction(TransactionType.LODGEMENT, 615.23, dtf.format(now), "Opening account", 615.23);
            Transaction t4 = new Transaction(TransactionType.LODGEMENT, 35.000, dtf.format(now), "Opening account", 35.000);
            Transaction t5 = new Transaction(TransactionType.LODGEMENT, 10.50, dtf.format(now), "Opening account", 10.50);

            // adding to database
            a1Transactions.add(t1);
            a2Transactions.add(t2);
            a3Transactions.add(t3);
            a4Transactions.add(t4);
            a5Transactions.add(t5);

            //seed for customer details
            Account a1 = new Account(AccountType.CURRENT, 00001, (int) (Math.random() * 10001), 100.00, a1Transactions);
            Account a2 = new Account(AccountType.CURRENT, 00002, (int) (Math.random() * 10001), 150.00, a2Transactions);
            Account a3 = new Account(AccountType.CURRENT, 00003, (int) (Math.random() * 10001), 1200.00, a3Transactions);
            Account a4 = new Account(AccountType.CURRENT, 00004, (int) (Math.random() * 10001), 300.00, a4Transactions);
            Account a5 = new Account(AccountType.CURRENT, 00005, (int) (Math.random() * 10001), 124.69, a5Transactions);

            // adding to database
            ac1.add(a1);
            ac2.add(a2);
            ac3.add(a3);
            ac4.add(a4);
            ac5.add(a5);

            //seed for customer details
            Customer c1 = new Customer(1, "keith Mahogany", "32 Escort cresent", "keithMahogany@student.ncirl.ie", "1234abcd1", ac1);
            Customer c2 = new Customer(2, "Look Kavanagh", "222 connely road", "LookKavanagh@twitter.ie", "1234abcd2", ac2);
            Customer c3 = new Customer(3, "Adam Firstman", "21 Ivy trust apt", "AdamFirstman@retro.ie", "1234abcd3", ac3);
            Customer c4 = new Customer(4, "Alo Erepo", "dudu lane Street", "AloErepo@yahoo.ie", "1234abcd4", ac4);
            Customer c5 = new Customer(5, "Christina Aquilera", "111 NCI road IFSC", "ChristinaAquilera@aol.ie", "1234abcd5", ac5);

            // adding to database
            customerList.add(c1);
            customerList.add(c2);
            customerList.add(c3);
            customerList.add(c4);
            customerList.add(c5);

            System.out.println("Details Updated");

            init = false;
        }
    }

    //get method to return list of customers
    public static List<Customer> getCustomerList() {
        return customerList;
    }
}
