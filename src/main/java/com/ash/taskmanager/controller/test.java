package com.ash.taskmanager.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/")
public class test {

    @RequestMapping(path = "/")
    public String test(){

        String message = "Hello Shahed";
        return message;
    }
}
