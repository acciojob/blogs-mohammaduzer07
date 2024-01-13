package com.driver.models;
import org.hibernate.annotations.CreationTimestamp;
import org.junit.jupiter.api.Timeout;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;
    private String title;
    private String content;
    @CreationTimestamp
    private Date pubDate;
    @OneToMany
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();


    public Blog(){

    }

    public Blog(String title, String content, Date pubDate, User user) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}