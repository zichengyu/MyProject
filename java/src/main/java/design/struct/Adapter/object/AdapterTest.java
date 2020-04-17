package design.struct.Adapter.object;

/**
 * User: 20160301301
 * Date: 2017/9/14 20:55
 * Comment:
 */
public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}