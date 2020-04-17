package demo.jdk.stack;

/**
 * User: 20160301301
 * Date: 2018/5/7 15:38
 * Comment:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 */
public class TestTenuringThreshold {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        //System.gc();

        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];  //262144 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB]; //4194304
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
