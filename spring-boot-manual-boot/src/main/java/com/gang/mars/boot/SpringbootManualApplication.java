package com.gang.mars.boot;

import gang.org.springframework.boot.GangSpringApplication;
import gang.org.springframework.boot.autoconfigure.GSpringBootApplication;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/10 8:48
 */
@GSpringBootApplication
public class SpringbootManualApplication {
    public static void main(String[] args) {
        GangSpringApplication.run(SpringbootManualApplication.class,args);
    }
}
