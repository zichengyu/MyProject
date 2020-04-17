package design.struct.Adapter.classs;

/**
 * User: 20160301301
 * Date: 2017/9/14 20:35
 * Comment:
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}