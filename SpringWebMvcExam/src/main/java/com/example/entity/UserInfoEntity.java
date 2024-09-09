package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
@Getter
@Setter
@ToString
public class UserInfoEntity {
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
}
