/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.services;

/**
 *
 * @author Adam Condon (x18392911)
 * @edited Luke Kavanagh (x17520686)
 */

import com.mycompany.myblog.models.Account;
import com.mycompany.myblog.models.Customer;
import com.mycompany.ourbank.database.Database;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private static final Database database = new Database();
    public static List<Customer> customers = Database.getCustomerList();

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        List<Account> newList = new ArrayList();
        customer.setCustomerID(customers.size() + 1);
        customer.setAccounts(newList);
        customers.add(customer);
        return customer;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Find customer by Email
    public Customer getCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail() == null ? email == null : customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    // Get all customer within search parameter (name , email)
    public List<Customer> getSearchCustomers(String name, String email) {
        List<Customer> matcheslist = new ArrayList<>();
        for (Customer q : getAllCustomers()) {
            if ((name == null || q.getName().equals(name))
                    && (email == null || q.getEmail().equals(email))) {
                matcheslist.add(q);
            }
        }
        return matcheslist;
    }

    // Remove customer by customer ID
    public Customer removeCustomerById(int cid) {
        return customers.remove(cid - 1);
    }

    // Get customer by customer ID
    public Customer getCustomer(int cId) {
        return customers.get(cId - 1);
    }

    // Change customer address
    public Customer changeCustomerAddress(int cid, Customer c) {
        customers.get(cid - 1).setAddress(c.getAddress());
        return c;
    }

    // Update customer after changes to accounts / transfers
    public static void updateCustomer(int cid, Customer customer) {
        System.out.println("updating customer.." + customer.getName());
        customers.set(cid - 1, customer);
    }
}
