package cn.itcast;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestThread1 extends Thread {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("现在时间：" + dateFormat.format(new Date()));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
