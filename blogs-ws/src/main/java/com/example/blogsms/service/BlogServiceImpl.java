package com.example.blogsms.service;

import com.example.blogsms.domain.Blog;
import com.example.blogsms.dto.request.BlogRequest;
import com.example.blogsms.dto.response.BlogResponse;
import com.example.blogsms.repository.BlogRepo;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl implements BlogService {

  private final BlogRepo blogRepo;
  private final ModelMapper modelMapper;

  @Override
  public BlogResponse save(BlogRequest blogRequest) {
    Blog blog;
    if (blogRequest.getId() == null) {
      blog = modelMapper.map(blogRequest, Blog.class);
      blog.setCreatedDate(Instant.now());
    } else {
      blog = blogRepo.getReferenceById(blogRequest.getId());
      blog.setContent(blogRequest.getContent());
      blog.setTitle(blogRequest.getTitle());
      blog.setModifiedDate(Instant.now());
    }
    blogRepo.save(blog);
    return modelMapper.map(blog, BlogResponse.class);
  }

  @Override
  public BlogResponse getById(Long id) {
    return modelMapper.map(blogRepo.getReferenceById(id), BlogResponse.class);
  }

  @Override
  public List<BlogResponse> getByUserId(long userId) {
    List<Blog> blogs = blogRepo.findAllByUserId(userId);
    return blogs.stream().map(blog -> modelMapper.map(blog, BlogResponse.class)).collect(Collectors.toList());
  }

  @Override
  public List<BlogResponse> getAll() {
    List<Blog> blogs = blogRepo.findAll();
    return blogs.stream().map(blog -> modelMapper.map(blog, BlogResponse.class)).collect(Collectors.toList());
  }

  @Override
  public void deleteById(Long id) {
    blogRepo.deleteById(id);
  }
}
