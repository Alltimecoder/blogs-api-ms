package com.example.userws.feigndata;

import com.example.userws.config.MyClientConfig;
import com.example.userws.dto.response.BlogDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blogs-ms", configuration = MyClientConfig.class)
public interface BlogClient {

  @GetMapping("/api/v1/blogs/user/{id}")
  @Retry(name = "blogs-ms")
  @CircuitBreaker(name = "blogs-ms", fallbackMethod = "getBlogsFallBack")
  List<BlogDTO> getBlogs(@PathVariable Long id);

  default List<BlogDTO> getBlogsFallBack(Long id, Throwable exception) {
    return new ArrayList<>();
  }
}
