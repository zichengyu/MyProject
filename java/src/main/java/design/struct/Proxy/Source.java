package design.struct.Proxy;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:22
 * Comment:
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}