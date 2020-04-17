package demo.jdk.classloader;

/**
 * User: 20160301301
 * Date: 2018/5/23 16:37
 * Comment:
 */
public class T {

    public static int k = 0;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public T(String str) {
        System.out.println("构造函数：" + (++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println("打印函数：" + (++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }
    public static void main(String[] args) {
        T t = new T("init");
    }
}
