package demo.jdk.grammar;

/**
 * User: 20160301301
 * Date: 2017/12/19 9:19
 * Comment:
 * 从JDK 1.7后，HotSpot 将常量池从永久代移到了元空间，正因为如此，JDK 1.7 后的intern方法在实现上发生了比较大的改变，
 * JDK 1.7后，intern方法还是会先去查询常量池中是否有已经存在，如果存在，则返回常量池中的引用，这一点与之前没有区别，
 * 区别在于，如果在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，而只是在常量池中生成一个对原字符串的引用
 */
public class StringLearn {
    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        String str2 = new String("str01");
        String str3 = new String("str01");
        //str2.intern();
        System.out.println(str2.intern() == str2);
        System.out.println(str3.intern() == str2.intern());
    }

    private static void test2() {
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();

        System.out.println(str1 == str2);//#1 false
        System.out.println(str1 == str3);//#2 true
    }

    private static void test3() {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr" + "01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr + "01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2);//#3 true
        System.out.println(str1 == str3);//#4 false
        System.out.println(str1 == str4);//#5 true
        System.out.println(str1 == str5);//#6 true
    }

    /**
     * 因为常量池中没有“str01”这个字符串，所以会在常量池中生成一个对堆中的“str01”的引用，
     * 而在进行字面量赋值的时候，常量池中已经存在，所以直接返回该引用即可
     * 因此str1和str2都指向堆中的字符串，返回true
     */
    private static void test4() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);//#7 堆中的字符串 true
    }

    private static void test5() {
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        String str3 = str2.intern();
        System.out.println(str2 == str1);//#8 false
        System.out.println(str2 == str3);//#8 false
        System.out.println(str1 == str3);//#8 true
    }
}
