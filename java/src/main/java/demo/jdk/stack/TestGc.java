package demo.jdk.stack;

/**
 * User: 20160301301
 * Date: 2018/5/2 16:41
 * Comment:
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:JavaDemo\gc.log
 */
public class TestGc {
    private static final int _1mb = 1024 * 1024;
    private Object instance = null;
    private byte[] bigSize = new byte[2 * _1mb];
    public static void main(String[] args) {
        TestGc objA = new TestGc();
        TestGc objB = new TestGc();
        objA.instance = objB;
        objB.instance = objA;

        System.gc();
    }
}
