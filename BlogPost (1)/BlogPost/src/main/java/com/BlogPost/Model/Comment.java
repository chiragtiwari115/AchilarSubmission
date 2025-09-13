package com.BlogPost.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    private String id;
    private String author;
    private String text;
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


    public Comment(Post post, String author, String text) {
        this.id = String.valueOf(System.currentTimeMillis());  // Generate unique ID
        this.author = author;
        this.text = text;
        this.post = post;
        this.createdAt = java.time.Instant.now().toString();
    }
}
