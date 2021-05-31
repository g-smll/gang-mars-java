package com.gang.mars.mvc.resouce;

import gang.org.springframework.annotation.Controller;
import gang.org.springframework.annotation.RequestMapping;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/28 12:32
 */
@Controller
public class UserResource {

    @RequestMapping("/getUser")
    public String getUser(){
        return "gang.chen";
    }
}
