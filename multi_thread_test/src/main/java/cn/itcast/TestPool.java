package cn.itcast;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String args[]){
        //1、创建服务，创建线程池，10是线程池大小
        ExecutorService service= Executors.newFixedThreadPool(10);

        //2执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.submit(new MyThread());

        //3、关闭
        service.shutdown();


        Map<String,String> map=new HashMap();
        map.put(null,null);
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"==="+Thread.currentThread().getName());
        }
    }
}
