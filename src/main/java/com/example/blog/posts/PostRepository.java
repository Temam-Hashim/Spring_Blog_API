package com.example.blog.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository  extends JpaRepository<Posts,Long> {
//    @Query("Select p from Posts p  where p.postAuthor like '%?%' or p.postTitle like '%?%' or p.postDesc like '%?1%'")
    List<Posts> findAllByPostAuthorContainingOrPostTitleContainingOrPostDescContaining(String desc,String title,String author);
}
