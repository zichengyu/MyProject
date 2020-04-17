package demo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * User: 20160301301
 * Date: 2017/9/11 14:58
 * Comment:
 */
public class MapTest {

    public static void main(String[] args) {

        /* 初始化map */
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println("HashMap的初始值:" + map.size());
        System.out.println("HashMap是否为空:" + (map.isEmpty() ? "是" : "否"));

        /* 想map中添加元素 */
        map.put("erqing", 1);
        map.put("niuniu", 2);
        map.put("egg", 3);
        System.out.println(map.size());
        ;
        System.out.println("HashMap是否为空:" + (map.isEmpty() ? "是" : "否"));

        /* 遍历HashMap中的元素 */
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + " " + map.get(s) + " " + "hashcode:"
                    + s.hashCode());
        }

        /*检测是否含有某个Key*/
        System.out.println(map.containsKey("egg"));

        /*检测是否含有某个Value*/
        System.out.println(map.containsValue(2));

        /*打印hashCode*/
        System.out.println(map.hashCode());
    }
}