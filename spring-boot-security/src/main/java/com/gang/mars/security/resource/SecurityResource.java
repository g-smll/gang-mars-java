package com.gang.mars.security.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/28 19:26
 */
@RestController
public class SecurityResource {

    @RequestMapping("/hello")
    public String hello(){
        return "hello security";
    }
}
