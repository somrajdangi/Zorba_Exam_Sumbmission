package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@ToString
public class UserInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_email")
    String userEmail;
    @Column(name = "user_mobile")
    String userMobile;
    @Column(name = "user_username")
    String userUserName;
    @Column(name = "user_password")
    String userPassword;

}
