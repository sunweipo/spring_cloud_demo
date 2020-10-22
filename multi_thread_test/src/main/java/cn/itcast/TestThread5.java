package cn.itcast;

import java.util.ArrayList;
import java.util.List;

public class TestThread5 implements Runnable {
    List<String> list=new ArrayList<String>();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            list.add(Thread.currentThread().getName());
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==="+list.size());

    }
}
