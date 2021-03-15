package com.mho.springboot.web;

import com.mho.springboot.config.auth.SecurityConfig;
import com.mho.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class) // 테스트상 Junit에 내장된 실행자외에 다른실행자(SpringRunner.class)를 실행, 스프링부트와 Junit의 연결자
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }) // WebMvc에 집중할 수 있는 어노테이션 @Controller, @ControllerAdivce에 사용
                                                 // @Service, @Component, @Repostory에는 사용 할 수 없다.
            // SecurityConfig.class 를 스캔대상에서 제외
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소로 HTTP GET 요청
                .andExpect(status().isOk()) // 상태가 200인지 아닌지를 검증
                .andExpect(content().string(hello)); // hello값이 맞는지에대한 검증
    }
    @WithMockUser(roles="USER")
    @Test
    public void helloDto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
    }

}
