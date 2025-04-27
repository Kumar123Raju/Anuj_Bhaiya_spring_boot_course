package com.example.ubberApp.ubberApp.Services;


import com.example.ubberApp.ubberApp.dto.DtoEntity;

import java.util.List;

public interface PostService {

    List<DtoEntity> getAllPosts();

    DtoEntity createPost(DtoEntity input);

    DtoEntity getById(Long id);

    DtoEntity updatePost(DtoEntity inputPost, Long postId);
}
