package com.leeahwants.book.springboot.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index"; //src/main/resources/templates/index.mustache로 전환되고 View Resolver 가 처리
    }
}
