package com.example.blog.posts;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table(name="posts")
public class Posts {
    @Id
    @SequenceGenerator(
            name="post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )

    @Column(name = "post_id")
    private Long postId;
    @Column(name = "post_author")
    private String postAuthor;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_desc")
    private String postDesc;
    @Column(name = "post_status")
    private String postStatus;
    @CreationTimestamp
    @Column(name = "post_date",nullable = false, updatable = false)
    private Date postDate;


    public Posts() {
    }

    public Posts(String postAuthor, String postTitle, String postDesc, String postStatus, Date postDate) {
        this.postAuthor = postAuthor;
        this.postTitle = postTitle;
        this.postDesc = postDesc;
        this.postStatus = postStatus;
        this.postDate = postDate;
    }

    public Posts(Long postId, String postAuthor, String postTitle, String postDesc, String postStatus, Date postDate) {
        this.postId = postId;
        this.postAuthor = postAuthor;
        this.postTitle = postTitle;
        this.postDesc = postDesc;
        this.postStatus = postStatus;
        this.postDate = postDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", postAuthor='" + postAuthor + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
