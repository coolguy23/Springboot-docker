package com.sisipapa.study.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class CommonController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String port(){
        return env.getProperty("server.port");
    }

    @GetMapping("/version")
    public String version(){
        return "v2";
    }

    @GetMapping("/hostname")
    public String hostname(HttpServletRequest request)  {
        return getLocalHostName();
    }

    private static String getLocalHostName(){
        String hostname = System.getenv("HOSTNAME");
        if(hostname !=null) {
            return hostname;
        }

        String lineStr ="";
        try {
            Process process = Runtime.getRuntime().exec("hostname");
            BufferedReader br =new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((lineStr = br.readLine()) !=null ){
                hostname = lineStr;
            }
        }catch (IOException e) {
            e.printStackTrace();
            hostname =null;
        }
        return hostname;
    }

}
