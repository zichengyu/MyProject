package demo.jdk.grammar;

/**
 * User: 20160301301
 * Date: 2017/10/27 11:43
 * Comment:
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        TestThread thread1 = new TestThread(testThreadLocal);
        TestThread thread2 = new TestThread(testThreadLocal);
        TestThread thread3 = new TestThread(testThreadLocal);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static class TestThread extends Thread {
        private TestThreadLocal sn;

        public TestThread(TestThreadLocal sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }
}