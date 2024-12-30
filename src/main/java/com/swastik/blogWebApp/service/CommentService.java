package com.swastik.blogWebApp.service;

import com.swastik.blogWebApp.dao.CommentDao;
import com.swastik.blogWebApp.dao.PostDao;
import com.swastik.blogWebApp.model.Comment;
import com.swastik.blogWebApp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    public Comment addComment(Long postId, Comment comment){
        Post post = postDao.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId + " -> This post id doesn't exists"));
        comment.setPost(post);
        return commentDao.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId){
        postDao.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId + " -> This post id doesn't exists"));
        return commentDao.findByPostId(postId);
    }

    public Comment updateComment(Long postId,Long commentId, Comment comment){
        Post post = postDao.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId + " -> This id doesn't exists"));
        comment.setId(commentId);
        comment.setPost(post);
        return commentDao.save(comment);
    }
    public void deleteComment(Long postId,Long commentId){
        if(postDao.findById(postId).isPresent()) {
            if (commentDao.findById(commentId).isPresent()) {
                commentDao.deleteById(commentId);
            } else {
                throw new RuntimeException(commentId + " -> This id doesn't exists");
            }
        }else {
            throw new RuntimeException(postId + " -> This id doesn't exists");
        }
    }
}
