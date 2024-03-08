package com.furina.furina_ahua_is_friend.sayhello.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    public class HelloController {

       @GetMapping("/sayhello" )
        public String hello() {
            return "Hello";
        }
    }
