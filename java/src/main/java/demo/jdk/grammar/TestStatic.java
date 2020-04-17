package demo.jdk.grammar;

/**
 * User: 20160301301
 * Date: 2018/4/9 11:03
 * Comment:
 * 1、静态块，静态属性->非静态块，属性->构造器
 * 2、对于静态块和静态属性或者非静态块和属性，初始化顺序决定于它们在代码中的顺序。
 * 3、上面三部分。父类的优先于子类
 * 父类的静态代码块和静态属性 》 子类的静态代码块和静态属性 》 父类的非静态代码块和非静态属性 》 子类的非静态代码块和非静态属性
 */
public class TestStatic {
    public static TestStatic t1 = new TestStatic("t1");
    public static TestStatic t2 = new TestStatic("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");
    public int m = 15;

    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public TestStatic(String str) {

        System.out.println("构造函数 :" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println("print方法:" + str + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }

    public static void main(String[] args) {
        TestStatic t = new TestStatic("init");
    }
}
