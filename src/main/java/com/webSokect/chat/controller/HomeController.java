package com.webSokect.chat.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HomeController {


    @RequestMapping("hello")
    public ResponseEntity<String> hello() {

        return ResponseEntity.ok("hello");
    }


}
