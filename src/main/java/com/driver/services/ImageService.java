package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blogRepository2.save(blog);
        return image;


    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count = 0;
        String[] dimArray = screenDimensions.split("X");
        Image image = imageRepository2.findById(id).get();
        String dimensionOfImage = image.getDimensions();
        String[] imgArray = dimensionOfImage.split("X");
        int imgX = Integer.parseInt(imgArray[0]);
        int imgY = Integer.parseInt(imgArray[1]);

        int dimX = Integer.parseInt(dimArray[0]);
        int dimY = Integer.parseInt(dimArray[1]);
        //4x4 = 4/2 * 4/2 = 4 images
        int cntX = dimX/imgX;
        int cntY = dimY/imgY;
        count = cntY*cntX;
        return count;
    }
}
