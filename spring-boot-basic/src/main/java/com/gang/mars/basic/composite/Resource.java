package com.gang.mars.basic.composite;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gang.chen
 * @description 生产者与消费者，以队列来实现
 * @time 2021/1/25 13:13
 */
public class Resource {
    //保证线程之间，变更的可见性
    private volatile boolean FLAG= true;

    //整形原子引用，保存多线程之间线程安全
    private final AtomicInteger atomicInteger = new AtomicInteger();

    //定义队列
    BlockingQueue<String> blockingQueue;

    //构造注入
    public Resource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //定义生产方法
    public void prod() throws InterruptedException {
        String data;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue= blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() +"\t 插入队列->"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName() +"\t 插入队列->"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t FLAG->"+FLAG+"生产暂停");
    }

    //定义消费方法
    public void consumer() throws InterruptedException{
        String result;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒未取到数据，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() +"\t 消费队列->"+result+"成功");
        }
    }

    //线程停止
    public void stop() {
        this.FLAG = false;
    }
}
