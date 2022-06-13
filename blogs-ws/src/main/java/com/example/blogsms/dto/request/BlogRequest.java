package com.example.blogsms.dto.request;


import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
  private Long id;
  private String title;
  private String content;
  private Long userId;
}
