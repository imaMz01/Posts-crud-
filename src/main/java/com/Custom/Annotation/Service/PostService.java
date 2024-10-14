package com.Custom.Annotation.Service;

import com.Custom.Annotation.Dto.PostDto;

import java.util.List;

public interface PostService {

    public PostDto add(PostDto postDto);
    public List<PostDto> posts();
    public PostDto update(PostDto postDto);
    public String delete(String id);
    public PostDto postById(String id);
}
