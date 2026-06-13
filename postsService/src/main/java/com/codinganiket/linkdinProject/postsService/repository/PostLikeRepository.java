package com.codinganiket.linkdinProject.postsService.repository;

import com.codinganiket.linkdinProject.postsService.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike,Long> {
    boolean existsByUserIdAndPostId(Long userId, long postId);

    void deleteByUserIdAndPostId(Long userId, long postId);
}
