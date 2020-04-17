package demo.collection;

import java.util.ArrayList;

/**
 * User: 20160301301
 * Date: 2017/9/11 15:41
 * Comment:
 */
public class ListTest {
    public static void main(String[] args) {

        /* 新建一个ArrayList */
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("初始化大小:" + list.size());

        /* 添加元素 */
        list.add("zzz");
        list.add("egg");
        list.add("hell");
        list.add("child");
        System.out.println("当前容量:" + list.size());

        /* 将ArrayList的大小和实际所含元素的大小设置一致 */
        list.trimToSize();

        /* 遍历 */
        for (String string : list) {
            System.out.println(string);
        }

        /* 在指定位置插入元素 */
        list.add(2, "zhu");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("--------------");

        /* 清空list */
        list.clear();

        /* 遍历 */
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("--------------");
    }
}