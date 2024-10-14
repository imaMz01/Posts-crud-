package com.Custom.Annotation.Mapper;

import com.Custom.Annotation.Dto.PostDto;
import com.Custom.Annotation.Entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper mapper = Mappers.getMapper(PostMapper.class);

    PostDto PostToPostDto(Post post);
    Post PostDtoToPost(PostDto postDto);
    List<PostDto> PostToPostDto(List<Post> post);
    List<Post> PostDtoToPost(List<PostDto> postDto);
}
