package com.mho.springboot.web;

import com.mho.springboot.model.response.SingleResult;
import com.mho.springboot.service.posts.PostsService;
import com.mho.springboot.service.response.ResponseService;
import com.mho.springboot.web.dto.PostsResponseDto;
import com.mho.springboot.web.dto.PostsSaveRequestDto;
import com.mho.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final 필드의 생성자 생성
@RestController
public class PostsApiController {
    
    private final PostsService postsService;
    private final ResponseService responseService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public SingleResult<PostsResponseDto> findById (@PathVariable Long id) {
        return responseService.getSingleResult(postsService.findById(id));
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
