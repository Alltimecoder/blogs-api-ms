package com.example.userws.domain;

import com.example.userws.enums.RoleType;
import com.example.userws.enums.Status;
import java.time.Instant;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Instant createdDate;
  private Instant modifiedDate;
  @Enumerated(EnumType.STRING)
  private Status status;
  private String userId;
  private String name;
  private String email;
  private String password;
  //roleType for segregating users
  @Enumerated(EnumType.STRING)
  private RoleType roleType;
  //a user can have multiple roles
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable
  private List<Role> roles;
}
