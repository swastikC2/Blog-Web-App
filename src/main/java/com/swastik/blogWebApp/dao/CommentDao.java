package com.swastik.blogWebApp.dao;

import com.swastik.blogWebApp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment,Long> {
    public List<Comment> findByPostId(Long postId);
}
