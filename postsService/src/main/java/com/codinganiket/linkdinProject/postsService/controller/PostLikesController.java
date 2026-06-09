package com.codinganiket.linkdinProject.postsService.controller;

import com.codinganiket.linkdinProject.postsService.dto.PostCreateRequestDto;
import com.codinganiket.linkdinProject.postsService.dto.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;

@RequestMapping("/likes")
public class PostLikesController {

    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostCreateRequestDto postDto){

    }
}
