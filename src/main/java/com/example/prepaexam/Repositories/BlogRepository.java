package com.example.prepaexam.Repositories;

import com.example.prepaexam.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
