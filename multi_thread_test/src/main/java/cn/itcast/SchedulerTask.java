package cn.itcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {
    int i=0;
    private int count=0;
    //@Scheduled(cron="*/6 * * * * ?")
    private void process(){
        new TestThread1().start();
        System.out.println("==="+i++);
    }

    //@Scheduled(cron="*/6 * * * * ?")
    private void process2(){
        System.out.println("==="+i++);
        new Thread(new TestThread2()).start();

    }

//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }
}
