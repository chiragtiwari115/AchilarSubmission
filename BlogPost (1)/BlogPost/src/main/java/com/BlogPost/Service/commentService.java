package com.blogapi.service;
import com.blogapi.model.Comment;
import com.blogapi.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class commentService {

    private List<Comment> comments = new ArrayList<>();
    private com.blogapi.service.PostService postService;

    public commentService(com.blogapi.service.PostService postService) {
        this.postService = postService;
    }

    public Comment addCommentToPost(String postId, String author, String text) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            Comment comment = new Comment(postId, author, text);
            comments.add(comment);
            post.getComments().add(comment);
            return comment;
        }
        return null;
    }

    public boolean deleteComment(String id) {
        Comment comment = comments.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (comment != null) {
            comments.remove(comment);
            return true;
        }
        return false;
    }
}
