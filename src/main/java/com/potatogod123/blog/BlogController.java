package com.potatogod123.blog;

import com.potatogod123.blog.data.CategoryRepository;
import com.potatogod123.blog.data.PostRepository;
import com.potatogod123.blog.model.Category;
import com.potatogod123.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private CategoryRepository categoryRepository;

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        List<Post> posts = postRepository.findAll();
        modelMap.put("posts", posts);
        List<Category> categories = categoryRepository.findAll();
        modelMap.put("categories", categories);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Post post = postRepository.findById(id).orElse(null);
        modelMap.put("post", post);
        return "post-details";
    }

    @RequestMapping("/category/{id}")
    public String categoryList(@PathVariable Long id, ModelMap modelMap){
        Category category = categoryRepository.findById(id).orElse(null);
        modelMap.put("category",category);
        List<Post> posts = postRepository.findByCategory(category);
        modelMap.put("posts",posts);
        List<Category> categories = categoryRepository.findAll();
        modelMap.put("categories",categories);
        return "category-list";
    }
}
