package com.example.blogsms.repository;

import com.example.blogsms.domain.Blog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {

  List<Blog> findAllByUserId(Long userId);
}
