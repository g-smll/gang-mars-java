package com.gang.mars.basic.callabled;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author gang.chen
 * @description JAVA线程的获取方式，CALLABLE
 * @time 2021/1/26 9:17
 */
public class CallableInstance {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new CallableThread());

        Thread thread = new Thread(task,"thread-aa");

        thread.start();

        int plusValue = 100;

        int finalValue = task.get() + plusValue;

        System.out.println("task result value ->" + task.get());

        System.out.println("final result value ->" + finalValue);
    }
}
