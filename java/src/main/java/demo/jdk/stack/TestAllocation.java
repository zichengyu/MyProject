package demo.jdk.stack;

/**
 * User: 20160301301
 * Date: 2018/5/7 15:05
 * Comment:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[1 * _1MB];
        a4 = new byte[6 * _1MB];
        Thread.sleep(1000000);
        //System.gc();
    }
}
