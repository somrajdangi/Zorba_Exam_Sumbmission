package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.inMemoryAuthentication()
                .withUser("admin")
                .password("admin@password")
                .roles("ADMIN");

    }

}
