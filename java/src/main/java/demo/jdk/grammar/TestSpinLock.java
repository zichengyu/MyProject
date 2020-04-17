package demo.jdk.grammar;

/**
 * User: 20160301301
 * Date: 2018/3/20 10:02
 * Comment: 自旋锁
 * 线程请求锁时，锁已经被其他线程占有，则线程会一直循环，并不停地请求锁已经被释放，从而获取锁
 */
public class TestSpinLock {
    private String objects = new String("a");

    boolean wasSignalled = false;

    public void doWait() {
        synchronized (objects) {
            while (!wasSignalled) {
                try {
                    objects.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (objects) {
            wasSignalled = true;
            objects.notify();
        }
    }

}
