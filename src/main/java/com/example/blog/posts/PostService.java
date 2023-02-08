package com.example.blog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Posts> GetPost(){
        return postRepository.findAll();
    }

    public Posts AddPost(Posts posts){
        return postRepository.save(posts);
    }

    public void DeletePost(Long postId){
        if(!postRepository.existsById(postId)){
            throw new IllegalStateException("No post found with ID NO.:"+postId);
        }
        postRepository.deleteById(postId);
    }

    public Posts UpdatePost(Long postId, Posts updatePosts){

        Posts posts = postRepository.findById(postId).orElseThrow();

        if(posts==null){
            return null;
        }

        if(updatePosts.getPostTitle()!=null){
            posts.setPostTitle(updatePosts.getPostTitle());
        }
        if(updatePosts.getPostAuthor()!=null){
            posts.setPostAuthor(updatePosts.getPostAuthor());
        }
        if(updatePosts.getPostDesc()!=null){
            posts.setPostDesc(updatePosts.getPostDesc());
        }
        if(updatePosts.getPostStatus()!=null){
            posts.setPostStatus(updatePosts.getPostStatus());
        }

        return postRepository.save(posts);
    }

    public Optional<Posts> GetPostById(Long postId){

        return postRepository.findById(postId);
    }

    public List<Posts> SearchPost(String search){
        if(search!=null) {
            return postRepository.findAllByPostAuthorContainingOrPostTitleContainingOrPostDescContaining(search,search,search);
        }
        return postRepository.findAll();
    }

}
