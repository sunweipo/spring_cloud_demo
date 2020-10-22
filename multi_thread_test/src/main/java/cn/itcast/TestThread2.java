package cn.itcast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class TestThread2 implements Runnable {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("现在时间：" + dateFormat.format(new Date()));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
