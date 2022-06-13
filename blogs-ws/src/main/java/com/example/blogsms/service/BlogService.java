package com.example.blogsms.service;

import com.example.blogsms.dto.request.BlogRequest;
import com.example.blogsms.dto.response.BlogResponse;
import java.util.List;

public interface BlogService {

  BlogResponse save(BlogRequest blogRequest);

  BlogResponse getById(Long id);

  List<BlogResponse> getByUserId(long userId);

  List<BlogResponse> getAll();

  void deleteById(Long id);
}
