package cn.itcast;

public class SynContainer {
    //设置容器大小
    Product [] products=new Product[10];
    int count=0;
    public synchronized void push(Product product) throws InterruptedException {
        //如果容器满了，需要等待消费者消费
        if(count==products.length){
            //通知消费者消费，生产者等待
            this.wait();
        }
        //没满，就放入产品
        products[count]=product;
        count++;
        //通知消费者消费
        this.notifyAll();
    }
    public synchronized Product pop() throws InterruptedException {
        //判断能否消费
        if(count==0){
            //等待生产者生产，消费者等待
            this.wait();
        }
            //可以消费
            count--;
            Product product=products[count];
            //通知生产者生产
            this.notifyAll();
            return product;
    }
}
