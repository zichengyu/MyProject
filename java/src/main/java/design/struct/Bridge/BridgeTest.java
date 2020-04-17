package design.struct.Bridge;

/**
 * User: 20160301301
 * Date: 2017/9/15 17:21
 * Comment:桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化
 */
public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Sourceable sourceable1 = new SourceSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();

        Sourceable sourceable2 = new SourceSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();
    }
}