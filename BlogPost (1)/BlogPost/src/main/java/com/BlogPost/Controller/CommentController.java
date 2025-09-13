package com.BlogPost.Controller;

import com.BlogPost.Model.Comment;
import com.BlogPost.Service.CommentService;
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


    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
    }
}
