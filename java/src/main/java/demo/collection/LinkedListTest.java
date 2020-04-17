package demo.collection;

import java.util.LinkedList;

/**
 * User: 20160301301
 * Date: 2017/9/11 16:02
 * Comment:
 */
public class LinkedListTest {
    public static void main(String[] args) {

        /* 新建一个list */
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(list.size());

        /* 向list中添加元素 */
        list.add(222);
        list.add(111);
        list.add(0);
        list.add(3333);
        list.add(8888);

        System.out.println(list.size());

        /* 遍历list */
        for (Integer integer : list) {
            System.out.println(integer);
        }

        /* 获取第一个元素 ,即header的next域*/
        System.out.println("第一个元素是:" + list.getFirst());

        /*获取最后一个元素,即header的previous域*/
        System.out.println("最后一个元素是:"+list.getLast());
    }
}