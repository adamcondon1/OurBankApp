/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.services;

import com.mycompany.myblog.models.Comment;
import com.mycompany.myblog.models.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keith Mahony(x17521139)
 */
public class CommentService {

    public static List<Message> list = new ArrayList<>();
    public static List<Comment> commentslist = new ArrayList<>();
    public static boolean init = true;

    public CommentService() {
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
            // Message m4 = new Message(4,"First", "Lisa");
            //Message m5 = new Message(5,"Fifth", "Jack");
            // Message m6 = new Message(6,"Third", "Margarete");

            list.add(m1);
            list.add(m2);
            list.add(m3);
            // list.add(m4);
            // list.add(m5);
            // list.add(m6);
            init = false;
        }
    }

    public List<Comment> getAllCommentsByMessage(int MessageID) {
        return list.get(MessageID - 1).getComments();
    }

    public Comment getCommentByID(int MessageID, int CommentID) {
        return list.get(MessageID - 1).getComments().get(CommentID - 1);
    }

    public List<Comment> getAllComments() {
        return commentslist;
    }

}
