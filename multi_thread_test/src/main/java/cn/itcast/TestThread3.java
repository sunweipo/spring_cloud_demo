package cn.itcast;

import java.util.concurrent.locks.ReentrantLock;

public class TestThread3  implements Runnable{
    private Integer ticketnum=20;
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //synchronized (ticketnum){
            try{
                lock.lock();
                if (ticketnum<=0) break;
                System.out.println(Thread.currentThread().getName() + "===" + "取到了第" + ticketnum-- + "张票");
            }finally {
                lock.unlock();
            }

            //}

        }
    }
}
