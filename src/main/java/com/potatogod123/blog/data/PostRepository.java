package com.potatogod123.blog.data;

import com.potatogod123.blog.model.Category;
import com.potatogod123.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByCategory(Category category);
}