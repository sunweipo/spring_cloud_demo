package cn.itcast.bean;

import org.springframework.context.annotation.Bean;

public class UserConfiguration {
    @Bean
    public User getUser(){
        User user=new User();
        user.setAge(25);
        user.setUsername("123");
        return user;
    }
}
