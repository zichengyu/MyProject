package design.create.singleton;

/**
 * User: 20160301301
 * Date: 2017/9/12 19:14
 * Comment:
 */
public class GreatnSingleton {

    /* 私有构造方法，防止被实例化 */
    private GreatnSingleton() {
    }

    /* 获取实例 */
    public static GreatnSingleton getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static GreatnSingleton instance = new GreatnSingleton();
    }
}