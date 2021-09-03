package qs.ttt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/12/21 10:31 下午
 */
public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer x  = ThreadLocalRandom.current().nextInt();
            System.out.println(Thread.currentThread().getName()+ " 生产了:" + x);
            try {
                queue.put(x);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
