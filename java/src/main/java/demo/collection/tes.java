package demo.collection;

import java.util.*;

/**
 * User: 20160301301
 * Date: 2017/9/11 16:39
 * Comment:
 */
public class tes {

    public static void main(String[] args) {
        int data[] = {2, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2,
                7, 8, 8, 7, 8, 7, 9, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : data) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> m : list) {
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }

}