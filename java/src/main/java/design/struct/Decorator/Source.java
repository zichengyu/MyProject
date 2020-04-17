package design.struct.Decorator;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:14
 * Comment:
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}