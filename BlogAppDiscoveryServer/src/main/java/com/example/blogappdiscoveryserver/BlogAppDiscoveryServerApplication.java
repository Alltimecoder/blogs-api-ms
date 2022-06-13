package com.example.blogappdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BlogAppDiscoveryServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogAppDiscoveryServerApplication.class, args);
  }

}
