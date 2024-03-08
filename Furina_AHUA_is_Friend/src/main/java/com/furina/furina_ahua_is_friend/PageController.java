package com.furina.furina_ahua_is_friend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/hi")
    public  String hiPage(){
        model.addAttribute("storyContent", message);
        return  "hi";
    }
    @GetMapping("/hello")
    public  String helloPage(){
        return  "hello";
    }
}
