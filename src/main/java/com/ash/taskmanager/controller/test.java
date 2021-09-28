package com.ash.taskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class test {

    @RequestMapping(path = "/")
    public String test(){

        String message = "Hello Ash";
        return message;
    }
}
