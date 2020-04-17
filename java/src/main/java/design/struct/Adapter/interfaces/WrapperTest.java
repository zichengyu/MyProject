package design.struct.Adapter.interfaces;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:01
 * Comment:
 */
public class WrapperTest {
    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}