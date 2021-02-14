package com.leeahwants.book.springboot.web;


import com.leeahwants.book.springboot.service.PostsService;
import com.leeahwants.book.springboot.web.dto.PostsResponseDto;
import com.leeahwants.book.springboot.web.dto.PostsSaveRequestDto;
import com.leeahwants.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") //새로운 글 등록(요청된 자원 생성):post
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 전체 수정(요청된 자원 수정-내용갱신): put
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") //요청받은 uri의 정보를 검색하여 응답한다
    public PostsResponseDto findById(@PathVariable Long id) {
       return postsService.findById(id);
    }
}