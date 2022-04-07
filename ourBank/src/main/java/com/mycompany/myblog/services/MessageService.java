/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

@Author 1: Keith Mahony - x17521138

*/
package com.mycompany.myblog.services;

import com.mycompany.myblog.models.Comment;
import com.mycompany.myblog.models.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public static List<Message> list = new ArrayList<>();
    public static List<Comment> commentslist = new ArrayList<>();
    public static boolean init = true;

    public MessageService() {
        if (init) {

            Comment c1 = new Comment(1, "One comment");
            Comment c2 = new Comment(2, "Another comment");
            Comment c3 = new Comment(3, "And another comment more");

            commentslist.add(c1);
            commentslist.add(c2);
            commentslist.add(c3);

            Message m1 = new Message(1, "First", "Manuel", commentslist);
            Message m2 = new Message(2, "Second", "Jack", commentslist);
            Message m3 = new Message(3, "Third", "Emer", commentslist);

            list.add(m1);
            list.add(m2);
            list.add(m3);
            init = false;
        }
    }

//    Get all messages
    public List<Message> getAllMessages() {
        return list;
    }

//    Get all messages within a search parameter 
    public List<Message> getSearchMessages(String message, String author) {
        List<Message> matcheslist = new ArrayList<>();
        for (Message q : getAllMessages()) {
            if ((message == null || q.getMessage().equals(message))
                    && (author == null || q.getAuthor().equals(author))) {
                matcheslist.add(q);
            }
        }
        return matcheslist;
    }

//    Get a specific messages
    public Message getMessage(int id) {
        return list.get(id - 1);
    }

//    Create a new message
    public Message createMessage(Message m) {
        m.setId(list.size() + 1);
        list.add(m);
        String mID = String.valueOf(m.getId());
        System.out.println("Resource created with path: /messages /" + mID);
        return m;
    }
}
