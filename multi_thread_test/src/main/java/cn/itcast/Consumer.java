package cn.itcast;

public class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("===消费了"+container.pop().id+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
