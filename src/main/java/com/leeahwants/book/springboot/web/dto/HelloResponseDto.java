package com.leeahwants.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Getter //선언된 모든 필드의 get 메소드 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자 생성해준다
public class HelloResponseDto{
    private final String name;
    private final int amount;

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

}


