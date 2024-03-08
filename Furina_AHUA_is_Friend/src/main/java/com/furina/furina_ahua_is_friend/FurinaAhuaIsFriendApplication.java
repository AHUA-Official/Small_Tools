package com.furina.furina_ahua_is_friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//,"com.furina.furina_ahua_is_friend.sayhello.hi"
@SpringBootApplication
@ComponentScan(basePackages = {"com.furina.furina_ahua_is_friend", "com.furina.furina_ahua_is_friend.sayhello.hello"})
public class FurinaAhuaIsFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurinaAhuaIsFriendApplication.class, args);
    }

}
