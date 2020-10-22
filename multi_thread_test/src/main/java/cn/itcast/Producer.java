package cn.itcast;

public class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container=container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("===生产了"+i+"只鸡");
            try {
                container.push(new Product(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
