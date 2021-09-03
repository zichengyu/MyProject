package qs.ttt;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/10/21 11:29 上午
 */
public class SingletonA {

    private SingletonA() {
    }

    private static class InstanceFactory {
        public static SingletonA instance = new SingletonA();
    }

    public static SingletonA getInstance() {
        return InstanceFactory.instance;
    }


    public Object readResolve() {
        return getInstance();
    }
}
