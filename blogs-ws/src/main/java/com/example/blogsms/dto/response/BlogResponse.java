package com.example.blogsms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {

  private Long id;
  private String title;
  private String content;
  private Long userId;
}
