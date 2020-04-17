package demo.jdk.grammar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: 20160301301
 * Date: 2018/3/20 11:17
 * Comment:阻塞队列实现
 */
public class ProducerAndConsumer {

    private int foodNum = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private final int MAX_NUM = 15;

    public void produce() {
        lock.lock();
        try {
            while (foodNum == MAX_NUM) {
                System.out.println("box is full，size = " + foodNum);
                notFull.await();
            }
            foodNum++;
            System.out.println("produce success foodNum = " + foodNum);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void consume() {
        lock.lock();
        try {
            while (foodNum == 0) {
                System.out.println("box is empty,size = " + foodNum);
                notEmpty.await();
            }
            foodNum--;
            System.out.println("consume success foodNum = " + foodNum);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public class Procedure extends Thread {
       public ProducerAndConsumer pac;

        public Procedure(ProducerAndConsumer pac) {
            this.pac = pac;
        }

        @Override
        public void run() {
            while (true) {
                pac.produce();
            }
        }
    }

    public class Consumer extends Thread {
        public ProducerAndConsumer pac;

        public Consumer(ProducerAndConsumer pac) {
            this.pac = pac;
        }

        @Override
        public void run() {
            while (true) {
                pac.consume();
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer pac = new ProducerAndConsumer();
        pac.new Procedure(pac).start();
        pac.new Consumer(pac).start();
    }
}
