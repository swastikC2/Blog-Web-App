package com.swastik.blogWebApp.dao;

import com.swastik.blogWebApp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post,Long> {
}
