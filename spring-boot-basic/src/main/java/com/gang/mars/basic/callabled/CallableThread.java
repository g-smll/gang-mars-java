package com.gang.mars.basic.callabled;

import java.util.concurrent.Callable;

/**
 * @author gang.chen
 * @description Callable 举例线程返回值
 * @time 2021/1/26 9:18
 */
public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" ->"+"CallableThread -> method -> call()");
        return 2048;
    }
}
