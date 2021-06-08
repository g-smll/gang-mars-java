package com.gang.mars.mvc.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/8 8:30
 */
@RestController
public class HelloWorld {

    @RequestMapping("/say")
    public String sayHello(){
        return "hello world!";
    }
}
