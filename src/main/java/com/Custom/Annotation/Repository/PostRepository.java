package com.Custom.Annotation.Repository;

import com.Custom.Annotation.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,String> {
}
