/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.resources;

import com.mycompany.myblog.models.Account;
import com.mycompany.myblog.models.Balance;
import com.mycompany.myblog.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Adam Condon (x18392911)
 * @edited Luke Kavanagh (x17520686)
 */

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource{

    private AccountService accountService = new AccountService();
    
        // Get request returning list of accounts for a customer
        @GET
	public List<Account> getAccounts(@PathParam("customerId") int cid) {
    	System.out.println("getAllAccountsForCustomer..."+cid);
        return accountService.getAllAccounts(cid);
	}
        
        //GET request returning specific account by account number
        @GET
        @Path("/{accountId}")
        public Account getAccount(@PathParam("customerId") int cid, @PathParam("accountId") int aId) {
        return accountService.getAccount(cid, aId);
        }
        
        //POST request to create a new account
        @POST
        @Path("/create/current")
        public Account postCurrentAccount(@PathParam("customerId") int cid) {
		return accountService.createCurrentAccount(cid);
        }   
        
        //POST request to create a new account
        @POST
        @Path("/create/savings")
        public Account postSavingsAccount(@PathParam("customerId") int cid) {
		return accountService.createSavingsAccount(cid);
        }   
        // DELETE Account
        @DELETE
        @Path("/remove/{accountId}")
        public Account removeAccount(@PathParam("accountId") int aid, @PathParam("customerId") int cid){
            return accountService.removeAccount(aid, cid);
        }
        
        // GET account balance
        @GET
        @Path("/{accountId}/balance")
        public Balance getBalance(@PathParam("customerId") int cid, @PathParam("accountId") int aid){
            System.out.println("getting account balance...");
            return accountService.getBalance(cid, aid);
        }
        
        // GET transactions resource for a specific account
        @Path("/{accountId}/transaction")
        public TransactionResource getTransactionResource() {
        System.out.println("getting Transaction Resource");
        return new TransactionResource();
        }
}