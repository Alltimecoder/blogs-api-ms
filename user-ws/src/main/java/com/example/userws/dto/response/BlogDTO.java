package com.example.userws.dto.response;

import lombok.Data;

@Data
public class BlogDTO {

  private Long id;
  private String title;
  private String content;
  private Long userId;
}
