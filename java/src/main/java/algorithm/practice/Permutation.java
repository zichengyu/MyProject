package algorithm.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * User: 20160301301
 * Date: 2017/11/25 14:10
 * Comment:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 * 递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();

        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }

        return res;
    }

    private static void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length - 1) { //解空间的一个叶节点
            list.add(String.valueOf(cs)); //找到一个解
        } else {
            for (int j = i; j < cs.length; ++j) {
                if (j == i || cs[j] != cs[i]) {
                    swap(cs, i, j);
                    PermutationHelper(cs, i + 1, list);
                    swap(cs, i, j); //复位
                }
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        new Permutation().Permutation("aac");
    }

}
