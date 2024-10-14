package com.Custom.Annotation.Controller;

import com.Custom.Annotation.Annotations.RequestLogger;
import com.Custom.Annotation.Annotations.ValidatePost;
import com.Custom.Annotation.Dto.PostDto;
import com.Custom.Annotation.Service.PostService;
import com.Custom.Annotation.Validation.AddGroup;
import com.Custom.Annotation.Validation.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;


    @RequestLogger(enabled = false)
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> posts(){
        return new ResponseEntity<>(postService.posts(), HttpStatus.OK);
    }

    @GetMapping("/postById/{id}")
    public ResponseEntity<PostDto> postById(@PathVariable String id){
        return new ResponseEntity<>(postService.postById(id), HttpStatus.OK);
    }

    @ValidatePost
    @PostMapping("/addPost")
    public ResponseEntity<PostDto> addPost(@Validated(AddGroup.class) @RequestBody PostDto postDto){
        return  new ResponseEntity<>(postService.add(postDto),HttpStatus.CREATED);
    }

    @ValidatePost
    @PutMapping("/update")
    public ResponseEntity<PostDto> updatePost(@Validated(UpdateGroup.class) @RequestBody PostDto postDto){
        return  new ResponseEntity<>(postService.update(postDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        return  new ResponseEntity<>(postService.delete(id),HttpStatus.OK);
    }
}
