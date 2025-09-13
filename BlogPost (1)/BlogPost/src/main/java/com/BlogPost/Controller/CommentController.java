package com.blogapi.controller;

import com.blogapi.model.Comment;
import com.blogapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@PathVariable String postId, @RequestBody Comment comment) {
        return commentService.addCommentToPost(postId, comment.getAuthor(), comment.getText());
    }

    @GetMapping
    public List<Comment> getComments(@PathVariable String postId) {
        return commentService.getPostById(postId).getComments();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
    }
}
