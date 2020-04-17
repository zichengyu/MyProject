package demo.jdk.grammar;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * User: 20160301301
 * Date: 2017/9/4 18:53
 * Comment:
 */
public class TestCallable {

    public static void main(String[] args) throws Exception{
       Callable<Integer> callable = new Callable<Integer>() {
           @Override
           public Integer call() throws Exception {
               return 3;
           }
       };
       FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
       Thread thread = new Thread(futureTask);
       thread.start();
       System.out.println(futureTask.get());
    }
}