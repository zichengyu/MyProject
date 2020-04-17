package design.struct.Proxy;

/**
 * User: 20160301301
 * Date: 2017/9/14 21:25
 * Comment:代理模式就是多一个代理类出来，替原对象进行一些操作
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}