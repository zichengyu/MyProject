package design.struct.Bridge;

/**
 * User: 20160301301
 * Date: 2017/9/15 17:05
 * Comment:
 */
public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}