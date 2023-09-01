package com.ssafy.special.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/test")
public class TestController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String apiTest(){
        return "출력잘 됩니다.";
    }
}
