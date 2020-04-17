package demo.jdk.other;

/**
 * @author :  20160301301
 * @date : 2018/7/30 11:03
 */
public class StaticTest {

    public static int k = 0;

    public static StaticTest t1 = new StaticTest("t1");
    public static int i = 10;
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public StaticTest(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }
    public static void main(String[] args) {
        StaticTest t = new StaticTest("init");
       Integer i1 = 300;
       Integer i2 = 300;
        System.out.println(i1 == i2);
    }


}
