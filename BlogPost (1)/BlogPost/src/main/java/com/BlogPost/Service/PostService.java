package com.blogapi.service;

import com.blogapi.model.Post;
import com.blogapi.model.Comment;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public Post createPost(String title, String content) {
        Post post = new Post(title, content);
        posts.add(post);
        return post;
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(String id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Post updatePost(String id, String title, String content) {
        Post post = getPostById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    public boolean deletePost(String id) {
        Post post = getPostById(id);
        if (post != null) {
            posts.remove(post);
            post.getComments().clear();
            return true;
        }
        return false;
    }

    public List<Comment> getCommentsByPostId(String postId) {
        Post post = getPostById(postId);
        if (post != null) {
            return post.getComments();
        }
        return new ArrayList<>();
    }
}
