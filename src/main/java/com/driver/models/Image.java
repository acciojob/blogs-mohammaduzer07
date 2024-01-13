package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String description;
    private String dimension;

    @ManyToOne
    @JoinColumn
    private Blog blog;
    public Image(){

    }
    public Image(int imageId, String description, String dimension, Blog blog) {
        this.imageId = imageId;
        this.description = description;
        this.dimension = dimension;
        this.blog = blog;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}