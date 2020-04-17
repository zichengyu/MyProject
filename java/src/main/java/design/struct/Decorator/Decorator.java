package design.struct.Decorator;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:14
 * Comment:
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}