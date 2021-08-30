package com.sisipapa.study.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String port(){
        return env.getProperty("server.port");
    }

}
