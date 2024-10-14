package com.Custom.Annotation.Service;

import com.Custom.Annotation.Dto.PostDto;
import com.Custom.Annotation.Entity.Post;
import com.Custom.Annotation.Exceptions.PostNotFound;
import com.Custom.Annotation.Mapper.PostMapper;
import com.Custom.Annotation.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService{

    private final PostRepository postRepository;


    @Override
    public PostDto add(PostDto postDto) {
        Post post = PostMapper.mapper.PostDtoToPost(postDto);
        post.setId(UUID.randomUUID().toString());
        return PostMapper.mapper.PostToPostDto(
                postRepository.save(post)
        );
    }

    @Override
    public List<PostDto> posts() {
        return PostMapper.mapper.PostToPostDto(
                postRepository.findAll()
        );
    }

    public Post helper(String id){
        return postRepository.findById(id).orElseThrow(
                () ->  new PostNotFound(id)
        );
    }

    @Override
    public PostDto update(PostDto postDto) {
        Post post = helper(postDto.getId());
        post.setNom(postDto.getNom());
        post.setAuthor(postDto.getAuthor());
        post.setPublicationDate(postDto.getPublicationDate());
        return PostMapper.mapper.PostToPostDto(
                postRepository.save(post)
        );
    }

    @Override
    public String delete(String id) {
        postRepository.delete(helper(id));
        return "Post was deleted successfully";
    }

    @Override
    public PostDto postById(String id) {
        return PostMapper.mapper.PostToPostDto(
                helper(id)
        );
    }
}
