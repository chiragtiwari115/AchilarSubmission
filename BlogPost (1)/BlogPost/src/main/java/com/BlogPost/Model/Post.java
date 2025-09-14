package com.BlogPost.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private String createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;  // For cascade delete

    public Post(String title, String content) {
        this.id = String.valueOf(System.currentTimeMillis());  // Generate unique ID
        this.title = title;
        this.content = content;
        this.createdAt = java.time.Instant.now().toString();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
