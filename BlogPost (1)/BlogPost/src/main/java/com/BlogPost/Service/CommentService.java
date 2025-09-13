package com.BlogPost.Service;

import com.BlogPost.Model.Comment;
import com.BlogPost.Model.Post;
import com.BlogPost.Repository.CommentRepository;
import com.BlogPost.Service.PostService;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment addCommentToPost(String postId, String author, String text) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            Comment comment = new Comment(postId, author, text);
            commentRepository.save(comment); // Save comment in database
            post.getComments().add(comment);  // Add comment to the post
            return comment;
        }
        return null;
    }

    public boolean deleteComment(String id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
