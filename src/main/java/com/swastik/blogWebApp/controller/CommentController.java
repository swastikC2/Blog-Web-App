package com.swastik.blogWebApp.controller;

import com.swastik.blogWebApp.model.Comment;
import com.swastik.blogWebApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{id}/addComment")
    public ResponseEntity<String> addComment(@PathVariable Long id, @RequestBody Comment comment) {
        Comment response = commentService.addComment(id, comment);
        return new ResponseEntity<>("Comment Created Successfully, Id -> " + response.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/post/{id}/allComments")
    public List<Comment> getCommentsByPostId(@PathVariable Long id){
        return commentService.getCommentsByPostId(id);
    }

    @PutMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long postId,@PathVariable Long commentId,@RequestBody Comment comment){
        Comment response = commentService.updateComment(postId,commentId,comment);
        return new ResponseEntity<>("Comment Updated Successfully, Id -> " + response.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>("Comment Deleted Successfully",HttpStatus.OK);
    }
}
