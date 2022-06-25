package com.example.prepaexam.Services;

import com.example.prepaexam.Models.Blog;
import com.example.prepaexam.Repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    private List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    private Blog getBlogById(Long id) {
        return blogRepository.findById(id).get();
    }

    private Blog saveBlog(Blog b) {
        return blogRepository.save(b);
    }
}
