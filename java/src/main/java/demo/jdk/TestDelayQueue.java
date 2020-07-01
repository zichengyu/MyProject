package demo.jdk;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/4/10
 * Comment      : 21:52
 */
public class TestDelayQueue {
    public static void main(String[] args) {
        TestDelayQueue t = new TestDelayQueue();
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(t.new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
        queue.add(t.new DelayTask("2", 3000L, TimeUnit.MILLISECONDS));
        queue.add(t.new DelayTask("3", 2000L, TimeUnit.MILLISECONDS));

        System.out.println("queue put done");

        while (!queue.isEmpty()) {
            try {
                DelayTask task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class DelayTask implements Delayed {
        public String name;
        public Long delayTime;
        public TimeUnit delayTimeUnit;
        public Long executeTime;//ms

        DelayTask(String name, long delayTime, TimeUnit delayTimeUnit) {
            this.name = name;
            this.delayTime = delayTime;
            this.delayTimeUnit = delayTimeUnit;
            this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
        }


        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            }
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

    }
}