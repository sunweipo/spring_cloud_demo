package cn.itcast;

import org.apache.catalina.Executor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
public class ThreadApplication {
    public static void main(String args[]) throws InterruptedException {
        SpringApplication.run(ThreadApplication.class,args);
        TestThread3 ticket=new TestThread3();
        new Thread(ticket,"sun").start();
        new Thread(ticket,"wang").start();
        new Thread(ticket,"zhang").start();
/*        TestThread4 t1=new TestThread4();
        TestThread4 t2=new TestThread4();
        TestThread4 t3=new TestThread4();
        ExecutorService service= Executors.newFixedThreadPool(3);
        service.submit(t1);
        service.submit(t2);
        service.submit(t3);*/
/*
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }
            ).start();
        }
        Thread.sleep(3000);
        System.out.println("==="+list.size());
*/


        //new Thread(new TestThread5()).start();
 /*       Runnable test=()->{
          for(int i=0;i<10;i++) System.out.println("==="+i);
        };
        Thread thread=new Thread(test);
        thread.start();

        //更加简洁化
        new Thread(()->{System.out.println("==="+12345);}).start();*/
    }
}
