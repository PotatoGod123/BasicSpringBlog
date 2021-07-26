package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    @RequestMapping("/")
    public String listPosts(ModelMap map){
        List<Post> allPost = postRepository.getAllPosts();
        map.put("posts",allPost);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap map){
        Post post = postRepository.findById(id);
        map.put("post",post);
        return "post-details";
    }

    public BlogController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
}
