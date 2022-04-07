/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Keith Mahony(x17521139)
 */
package com.mycompany.myblog.resources;

import com.mycompany.myblog.models.Comment;
import com.mycompany.myblog.services.CommentService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService CommentService = new CommentService();

    @GET
    public List<Comment> getComments(@PathParam("messageID") int m_id) {
        System.out.println("getAllCommentsForMessage..." + m_id);
        return CommentService.getAllCommentsByMessage(m_id);
    }

    @GET
    @Path("/{commentID}")
    public Comment getComment(@PathParam("commentID") int c_id,
            @PathParam("messageID") int m_id) {
        System.out.println("getCommentByID..." + c_id + " for MEssageID " + m_id);
        return CommentService.getCommentByID(m_id, c_id);
    }

}