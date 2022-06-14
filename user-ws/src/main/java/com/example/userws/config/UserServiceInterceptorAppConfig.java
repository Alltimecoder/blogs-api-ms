package com.example.userws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class UserServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
   @Autowired
   MyClientConfig myClientConfig;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(myClientConfig);
   }
}