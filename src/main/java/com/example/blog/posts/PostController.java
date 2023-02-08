package com.example.blog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<Posts> GetPost(){
        return postService.GetPost();
    }

    @PostMapping
    public Posts AddPost(@RequestBody Posts posts){
        return postService.AddPost(posts);
    }

    @DeleteMapping(path="{postId}")
    public void DeletePost(@PathVariable("postId") Long postId){
        postService.DeletePost(postId);
    }

    @PutMapping(path="{postId}")
    public void UpdatePost(@PathVariable("postId") Long postId, @RequestBody Posts posts){
        postService.UpdatePost(postId,posts);
    }

    @GetMapping(path = "{postId}")
    public Optional<Posts> GetPostById(@PathVariable("postId") Long postId){

        return postService.GetPostById(postId);
    }
    @GetMapping("/search")
    public List<Posts> SearchPost(@RequestParam(required = false) String search){
        return postService.SearchPost(search);
    }
}
