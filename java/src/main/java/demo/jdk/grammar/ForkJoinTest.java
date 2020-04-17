package demo.jdk.grammar;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author :  20160301301
 * @date : 2018/7/26 19:05
 */
public class ForkJoinTest {
    private int[] d = new int[1000000];
    int subCount;

    private class MyForkJoinTask extends RecursiveTask {
        private int first;
        private int last;

        public MyForkJoinTask(int first, int last) {
            this.first = first;
            this.last = last;
            Random random = new Random();
            for (int i = 0; i < 1000000; i++) {
                d[i] = random.nextInt(1000);
            }
        }

        protected Integer compute() {

            if (last - first < 10) {
                subCount = 0;
                for (int i = first; i <= last; i++) {
                    if (d[i] < 1000) {
                        subCount++;
                    }
                }
            } else {
                int mid = (first + last) / 2;
                ForkJoinTask left = new MyForkJoinTask(first, mid);
                left.fork();
                ForkJoinTask right = new MyForkJoinTask(mid + 1, last);
                right.fork();
            }
            return subCount;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest forkJoinTest = new ForkJoinTest();
        ForkJoinTask task = forkJoinTest.new MyForkJoinTask(0, 1000);
        pool.submit(task);
        //pool.awaitTermination(10, TimeUnit.SECONDS);
        while (!task.isDone()) {
            System.out.println("RS");
        }
        pool.shutdown();
        System.out.println(forkJoinTest.subCount);
    }
}
