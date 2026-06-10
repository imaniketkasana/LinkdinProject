package com.codinganiket.linkdinProject.postsService.repository;

import com.codinganiket.linkdinProject.postsService.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
