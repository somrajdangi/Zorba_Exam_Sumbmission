package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="userinfo")
@Getter
@Setter

public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_email")
    String userEmail;
    @Column(name = "user_mobile")
    String userMobile;
    @Column(name = "user_user_name")
    String userUserName;
    @Column(name = "user_password")
    String userPassword;
    @Column(name = "user_role")
    String userRole;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
   List<Role> roleList;
}