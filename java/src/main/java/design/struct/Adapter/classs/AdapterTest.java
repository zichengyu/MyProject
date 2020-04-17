package design.struct.Adapter.classs;

/**
 * User: 20160301301
 * Date: 2017/9/14 20:38
 * Comment:
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}