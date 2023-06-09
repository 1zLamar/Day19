package com.example.day18blog.Repository;

import com.example.day18blog.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Blog findBlogById(Integer id);

    Blog findBlogByTitle(String title);

    List<Blog> findAllByCategory(String category);








}
