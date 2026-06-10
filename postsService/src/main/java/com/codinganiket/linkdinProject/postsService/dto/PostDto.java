package com.codinganiket.linkdinProject.postsService.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
public class PostDto {
    private long id;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
}
