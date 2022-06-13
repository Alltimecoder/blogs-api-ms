package com.example.blogsms.controller;

import com.example.blogsms.dto.request.BlogRequest;
import com.example.blogsms.dto.response.BlogResponse;
import com.example.blogsms.service.BlogService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/blogs")
public class BlogController {

  private final BlogService blogService;

  @GetMapping("/status")
  private ResponseEntity<String> status() {
    return ResponseEntity.ok("UP");
  }

  @PostMapping
  public ResponseEntity<BlogResponse> save(@RequestBody BlogRequest blogRequest) {
    return ResponseEntity.ok(blogService.save(blogRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    blogService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<BlogResponse>> getAll() {
    return ResponseEntity.ok(blogService.getAll());
  }

  @PutMapping
  public ResponseEntity<BlogResponse> update(@RequestBody BlogRequest blogRequest) {
    return ResponseEntity.ok(blogService.save(blogRequest));
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<BlogResponse>> getAllByUserId(@PathVariable Long id) {
    return ResponseEntity.ok(blogService.getByUserId(id));
  }

}
