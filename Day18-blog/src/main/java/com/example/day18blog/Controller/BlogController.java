package com.example.day18blog.Controller;

import com.example.day18blog.Model.Blog;
import com.example.day18blog.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        List<Blog> blogList=blogService.getAllBlog();
        return ResponseEntity.status(200).body(blogList);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogService.AddBlog(blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog,@PathVariable Integer id){
        blogService.updateBlog(blog,id);
        return ResponseEntity.status(200).body("Blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Blog deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blog blog=blogService.findBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        Blog blog=blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBlogByCategory(@PathVariable String category){
      List<Blog> blog= blogService.findAllByCategory(category);
      return ResponseEntity.status(200).body(blog);

    }

    @PutMapping("/update-false/{id}")
    public ResponseEntity updateBlogByPublished(@PathVariable Integer id){
        Blog blogList=blogService.updateBlogByPublished(id);
        return ResponseEntity.status(200).body(blogList);
    }



}
