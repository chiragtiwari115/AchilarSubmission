package com.BlogPost.Model;

import lombok.Data;

@Data
public class Comment {
    private String id;
    private String postId;
    private String author;
    private String text;
    private String createdAt;

    public Comment(String postId, String author, String text) {
        this.id = String.valueOf(System.currentTimeMillis());  // Generate unique ID
        this.postId = postId;
        this.author = author;
        this.text = text;
        this.createdAt = java.time.Instant.now().toString();
    }
}
