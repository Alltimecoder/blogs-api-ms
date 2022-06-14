package com.example.blogsms;

import com.example.blogsms.dto.response.BlogResponse;
import com.example.blogsms.repository.BlogRepo;
import com.example.blogsms.service.BlogService;
import com.example.blogsms.service.BlogServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

  @Mock
  private BlogResponse blogResponse;
  @Mock
  private BlogRepo blogRepo;
  @Mock
  private ModelMapper modelMapper;
  private BlogService blogService;

  @BeforeEach
  void setUp() {
    this.blogService = new BlogServiceImpl(blogRepo, modelMapper);
  }

  @Test
  void getAllBlogs() {
    blogService.getAll();
    Mockito.verify(blogRepo).findAll();
  }

  @Test
  void testGetById() {
    Assertions.assertNotNull(blogService.getById(1L));
  }

}
