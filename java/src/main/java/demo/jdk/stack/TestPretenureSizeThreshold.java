package demo.jdk.stack;

/**
 * User: 20160301301
 * Date: 2018/5/7 15:25
 * Comment:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a;
        a = new byte[4 * _1MB];
    }
}
