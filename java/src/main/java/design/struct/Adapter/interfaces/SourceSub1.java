package design.struct.Adapter.interfaces;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:00
 * Comment:
 */
public class SourceSub1 extends Wrapper2 {
    @Override
    public void method1() {
        System.out.println("the sourceable interface's first Sub1!");
    }
}