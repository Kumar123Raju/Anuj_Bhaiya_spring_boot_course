package com.example.ubberApp.ubberApp.Services;

import com.example.ubberApp.ubberApp.Entities.PostEntity;
import com.example.ubberApp.ubberApp.Repository.PostRepository;
import com.example.ubberApp.ubberApp.dto.DtoEntity;
import com.example.ubberApp.ubberApp.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DtoEntity> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map((value)->modelMapper.map(value, DtoEntity.class))
                .collect(Collectors.toList());
    }

    @Override
    public DtoEntity createPost(DtoEntity input) {
        PostEntity postEntity=modelMapper.map(input,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),DtoEntity.class);
    }

    @Override
    public DtoEntity getById(Long id) {
        PostEntity postEntity=postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post are not availalbe for this id: "+id));
        return  modelMapper.map(postRepository.findById(id),DtoEntity.class);
    }

    @Override
    public DtoEntity updatePost(DtoEntity inputPost, Long postId) {
        PostEntity oldePost=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post are not available for this id: "+postId));
        inputPost.setId(oldePost.getId());
        modelMapper.map(inputPost,oldePost);
        return modelMapper.map(postRepository.save(oldePost),DtoEntity.class);
    }
}
