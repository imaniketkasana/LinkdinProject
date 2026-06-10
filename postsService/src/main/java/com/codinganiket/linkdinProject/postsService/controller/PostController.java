package com.codinganiket.linkdinProject.postsService.controller;

import com.codinganiket.linkdinProject.postsService.dto.PostCreateRequestDto;
import com.codinganiket.linkdinProject.postsService.dto.PostDto;
import com.codinganiket.linkdinProject.postsService.service.PostService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostCreateRequestDto postCreateRequestDto,
                                             HttpServletRequest httpServletRequest){
    PostDto postDto=postService.createPost(postCreateRequestDto, 1L);
    return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }
}
