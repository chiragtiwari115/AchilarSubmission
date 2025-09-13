package com.BlogPost.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<com.blogapi.model.Comment, com.blogapi.model.Post> {
}




