/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


    @Author 1: Keith Mahony - x17521138


 */
package com.mycompany.myblog.resources;

import com.mycompany.myblog.models.Message;
import com.mycompany.myblog.services.MessageService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

@Path("/messages")

public class MessageResource {

    MessageService messageService = new MessageService();

//    //    May not be required 
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public List<Message> getMessagesXML() {
//        return messageService.getAllMessages();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Message> getMessagesJSON() {
//        return messageService.getAllMessages();
//    }
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessageXML(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageJSON(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message postMessageJSON(Message m) {
        return messageService.createMessage(m);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Message postMessageXML(Message m) {
        return messageService.createMessage(m);
    }

//    Get a message by its ID, or search for a Message.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.APPLICATION_XML)
    public List<Message> getFilteredMessages(@QueryParam("message") String message, @QueryParam("author") String author) {
        if ((message != null) || (author != null)) {
            return messageService.getSearchMessages(message, author);
        }
        return messageService.getAllMessages();
    }

    @Path("/{messageID}/comments")
    public CommentResource getCommentsResource() {
        System.out.println("Getting comments subresoruces...");
        return new CommentResource();
    }

}
