package design.struct.Adapter.object;

/**
 * User: 20160301301
 * Date: 2017/9/14 20:53
 * Comment:
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}