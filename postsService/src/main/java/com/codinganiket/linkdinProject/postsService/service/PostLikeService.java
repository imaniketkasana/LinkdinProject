package com.codinganiket.linkdinProject.postsService.service;

import com.codinganiket.linkdinProject.postsService.entity.Post;
import com.codinganiket.linkdinProject.postsService.entity.PostLike;
import com.codinganiket.linkdinProject.postsService.exception.BadRequestException;
import com.codinganiket.linkdinProject.postsService.exception.ResourceNotFoundException;
import com.codinganiket.linkdinProject.postsService.repository.PostLikeRepository;
import com.codinganiket.linkdinProject.postsService.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void likePost(long postId) {
        Long userId=1L;
        log.info("user with Id : {} liking the post with Id: {}", userId, postId);

        postRepository.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post not found with Id: "+postId));

        boolean hasAlreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId,postId);
        if(hasAlreadyLiked) throw new BadRequestException("You cannot like the post again");

        PostLike postLike =new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLikeRepository.save(postLike);
        // TODO: send notification to the owner of the post
    }
@Transactional
    public void unlikePost(long postId) {
        Long userId=1L;
        log.info("user with Id : {} unliking the post with Id: {}", userId, postId);

        postRepository.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post not found with Id: "+postId));

        boolean hasAlreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId,postId);
        if(!hasAlreadyLiked) throw new BadRequestException("You cannot unlike the post that you have not like");

        postLikeRepository.deleteByUserIdAndPostId(userId,postId);
    }
}
