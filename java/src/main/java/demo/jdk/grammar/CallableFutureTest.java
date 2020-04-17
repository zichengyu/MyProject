package demo.jdk.grammar;

import java.util.concurrent.*;

/**
 * User: 20160301301
 * Date: 2018/3/20 14:06
 * Comment: 获取线程执行结果
 * Callable用于产生结果，Future用于获取结果
 */
public class CallableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("start main thread ");
        ExecutorService exec = Executors.newFixedThreadPool(3);

        //新建一个Callable 任务，并将其提交到一个ExecutorService. 将返回一个描述任务情况的Future.
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start new thread ");
                Thread.sleep(5000);
                System.out.println("end new thread ");
                return "我是返回的内容";
            }
        };

        Future<String> task = exec.submit(call);
        Thread.sleep(1000);

        String retn = task.get();

        exec.shutdown();

        System.out.println(retn + "--end main thread");
    }

}
