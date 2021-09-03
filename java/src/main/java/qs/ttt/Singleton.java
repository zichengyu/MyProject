package qs.ttt;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/10/21 11:08 上午
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            initInstance();
        }
        return instance;
    }

    private static synchronized void initInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
    }
}
