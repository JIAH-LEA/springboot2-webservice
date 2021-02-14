package com.leeahwants.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//스프링부트 테스트와 JUnit 사이의 연결자 역할
@RunWith(SpringRunner.class)
//스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
@WebMvcTest
public class HelloControllerTest {
    // 스프링을 관리하는 빈(Bean)을 주입받는다
    @Autowired
    private MockMvc mvc; //웹 API 테스트시 사용(시작점 클래스)

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        //MockMvc를 통해 get 요청
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //상태검증(200,404.500 : 200인지 아닌지 검증)
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증
    }
    @Test
    public void helloDto가_리턴된다()throws Exception{
        String name ="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name) //api를 테스트할 때 사용 될 요청 파라미터 사용(string만 가능)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))// json 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
