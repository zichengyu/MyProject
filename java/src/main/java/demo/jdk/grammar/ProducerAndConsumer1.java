package demo.jdk.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :  20160301301
 * @date : 2018/9/6 19:47
 */
public class ProducerAndConsumer1 {

    public class Produre implements Runnable {
        private ArrayBlockingQueue queue;

        public Produre(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                Object o = new Object();
                try {
                    Thread.sleep(100);
                    queue.put(o);
                    System.out.println("生产者生产了：" + o.toString() + " 资源队列大小= " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable {
        private ArrayBlockingQueue queue;

        public Consumer(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Object o = queue.take();
                    Thread.sleep(1000);
                    System.out.println("消费者消费了：" + o.toString() + " 资源队列大小= " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer1 pc = new ProducerAndConsumer1();
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        ExecutorService executor = Executors.newFixedThreadPool(15);

        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Produre p = pc.new Produre(queue);
            executor.execute(p);

        }

        for (int i = 0; i < 10; i++) {
            Consumer c = pc.new Consumer(queue);
            executor.execute(c);
        }

        Thread.sleep(10000);
    }

}
