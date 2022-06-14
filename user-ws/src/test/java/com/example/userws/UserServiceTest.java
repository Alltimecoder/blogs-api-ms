package com.example.userws;

import com.example.userws.domain.User;
import com.example.userws.feigndata.BlogClient;
import com.example.userws.repository.RoleRepo;
import com.example.userws.repository.UserRepo;
import com.example.userws.service.UserService;
import com.example.userws.service.impl.UserServiceImpl;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  private UserRepo userRepo;
  @Mock
  private RoleRepo roleRepo;
  private PasswordEncoder passwordEncoder;
  @Mock
  private ModelMapper modelMapper;
  @Mock
  private BlogClient blogClient;
  private UserService userService;

  @BeforeEach
  void setUp() {
    this.passwordEncoder = new BCryptPasswordEncoder();
    this.userService = new UserServiceImpl(userRepo, roleRepo, passwordEncoder, blogClient, modelMapper);
  }

  @Test
  void testGetAll() {
    List<User> userList = userService.getAll();
    List<User> users = userRepo.findAll();
    Assertions.assertArrayEquals(userList.toArray(), users.toArray());
  }

}
