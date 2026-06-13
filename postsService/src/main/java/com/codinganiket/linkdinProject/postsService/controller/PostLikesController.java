package com.codinganiket.linkdinProject.postsService.controller;

import com.codinganiket.linkdinProject.postsService.dto.PostCreateRequestDto;
import com.codinganiket.linkdinProject.postsService.dto.PostDto;
import com.codinganiket.linkdinProject.postsService.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@RequestMapping("/likes")
@RequiredArgsConstructor
@RestController
public class PostLikesController {

     private final PostLikeService postLikeService;

     @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable long postId){
         postLikeService.likePost(postId);
         return ResponseEntity.noContent().build();
     }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable long postId){
        postLikeService.unlikePost(postId);
        return ResponseEntity.noContent().build();
    }

}
