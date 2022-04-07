/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.resources;

import com.mycompany.myblog.models.Transaction;
import com.mycompany.myblog.services.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Keith Mahony (x17521139)
 * @edited Luke Kavanagh (x17520686) - Lodgements 
 * 
 */
@Path("/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    private TransactionService transactionService = new TransactionService();
    
//    Get all the transactions from an account
    @GET
    public List<Transaction> getTransactions(@PathParam("customerId") int cID, @PathParam("accountId") int aID) {
        return transactionService.getTransactions(cID, aID);
    }

/*                                    Resource Usage Guide
        
        LODGE: localhost:49000/api/customers/[customerID]/accounts/[accountID]/transaction?type=lodge
        json example -> {"amount": "100",
                         "description": "Cash Lodgement" }
    
        WITHDRAW: localhost:49000/api/customers/[customerID]/accounts/[accountID]/transaction?type=withdraw
        json example -> {"amount": "50",
                         "description": "Cash Withdrawal" }
    
        TRANSFER: localhost:49000/api/customers/[customerID]/accounts/[accountID]/transaction?type=transfer&recipientCustId=1&recipientAccountId=1
*/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction makeTransactionJSON(@PathParam("customerId") int cID,
            @PathParam("accountId") int aID,
            @QueryParam("type") String type,
            @QueryParam("recipientCustId") int recipientCustomerId,
            @QueryParam("recipientAccountId") int recipientAccountId,
            Transaction t) {
        if(type.equals("lodge")){
            return transactionService.makeLodgement(cID, aID, t);
        }
        if(type.equals("withdraw")){
            System.out.println("Withdraw...");
            return transactionService.makeWithdrawal(cID, aID, t);
        }
        if(type.equals("transfer")){
            return transactionService.makeTransfer(cID, aID, recipientCustomerId, recipientAccountId, t);
        }      
        return t;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Transaction makeTransactionXML(@PathParam("customerId") int cID,
            @PathParam("accountId") int aID,
            @QueryParam("type") String type,
            @QueryParam("recipientCustId") int recipientCustomerId,
            @QueryParam("recipientAccountId") int recipientAccountId,
            Transaction t) {
        if(type.equals("lodge")){
            return transactionService.makeLodgement(cID, aID, t);
        }
        if(type.equals("withdraw")){
            return transactionService.makeWithdrawal(cID, aID, t);
        }
        if(type.equals("transfer")){
            return transactionService.makeTransfer(cID, aID, recipientCustomerId, recipientAccountId, t);
        }      
        return t;
    }
}