package com.example.blogsapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BlogsApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogsApiGatewayApplication.class, args);
  }

}
