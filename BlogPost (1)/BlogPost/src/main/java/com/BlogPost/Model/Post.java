package com.blogapi.model;

import com.BlogPost.Model.Comment;
import lombok.Data;
import java.util.List;

@Data
public class Post {
    private String id;
    private String title;
    private String content;
    private String createdAt;
    private List<com.blogapi.model.Comment> comments;  // For cascade delete

    public Post(String title, String content) {
        this.id = String.valueOf(System.currentTimeMillis());  // Generate unique ID
        this.title = title;
        this.content = content;
        this.createdAt = java.time.Instant.now().toString();
    }
}
