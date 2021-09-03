package qs.ttt;

import java.util.concurrent.BlockingQueue;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/12/21 10:31 下午
 */
public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer x = queue.take();
                System.out.println(Thread.currentThread().getName()+ " 消费了：" + x);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

//    @Override
//    public Object call() throws Exception {
//        return null;
//    }
}
