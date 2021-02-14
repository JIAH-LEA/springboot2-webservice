package com.leeahwants.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController: json을 반환하는 컨트롤러로 만들어줌
@RestController
public class HelloController {
    //GetMapping: HTTP Method 인 Get 요청을 받을 수 잇는 API를 만들어 준다
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
