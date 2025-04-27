package com.example.ubberApp.ubberApp.Controllers;

import com.example.ubberApp.ubberApp.Services.PostService;
import com.example.ubberApp.ubberApp.advice.ApiSuccess;
import com.example.ubberApp.ubberApp.dto.DtoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/getPost/{id}")
    public ResponseEntity<ApiSuccess> getPostById(@PathVariable Long id){
        ApiSuccess apiSuccess=new ApiSuccess("Data Fetched", HttpStatus.OK,postService.getById(id));
        return new ResponseEntity<>(apiSuccess,HttpStatus.OK);

    }

    @GetMapping("/getPost")
    public List<DtoEntity> getPostById(){
        return postService.getAllPosts();

    }

    @PostMapping("/createPost")
    public DtoEntity createPost(@RequestBody DtoEntity input){
        return postService.createPost(input);
    }

    @PutMapping("/updatePost/{postId}")
    public DtoEntity updatePost(@RequestBody DtoEntity inputPost,@PathVariable Long postId){
        return postService.updatePost(inputPost,postId);


    }
}
