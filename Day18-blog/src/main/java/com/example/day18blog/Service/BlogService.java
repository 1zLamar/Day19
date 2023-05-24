package com.example.day18blog.Service;

import com.example.day18blog.ApiException.ApiException;
import com.example.day18blog.Model.Blog;
import com.example.day18blog.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }

    public void AddBlog(Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(Blog blog, Integer id){
        Blog blog1=blogRepository.findBlogById(id);
        if(blog1==null){
            throw new ApiException("not found");
        }

        blog1.setTitle(blog.getTitle());
        blog1.setCategory(blog.getCategory());
        blog1.setBody(blog.getBody());
        blog1.setPublished(blog.isPublished());

        blogRepository.save(blog1);
    }

    public void deleteBlog(Integer id){
        Blog blog1=blogRepository.findBlogById(id);
        if(blog1==null){
            throw new ApiException("not found");
        }
        blogRepository.delete(blog1);
    }

    public Blog findBlogById(Integer id){
        Blog blog1=blogRepository.findBlogById(id);
        if(blog1==null){
            throw new ApiException("not found");
        }
        return blog1;
    }

    public Blog findBlogByTitle(String title){
        Blog blog=blogRepository.findBlogByTitle(title);
        if(blog==null){
            throw new ApiException("not found");
        }
        return blog;
    }

    public List<Blog> findAllByCategory(String category){
        List<Blog> blogList=blogRepository.findAllByCategory(category);
        if (blogList==null){
            throw new ApiException("not found");
        }
        return blogList;
    }

    public Blog updateBlogByPublished(Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if (blog==null){
            throw new ApiException("not found");
        }
        if(blog.isPublished()){
            throw new ApiException("true cannot change");
        }
        blog.setPublished(true);
        blogRepository.save(blog);
        return blog;
    }


}
