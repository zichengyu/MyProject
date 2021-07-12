package algorithm.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * //给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * //
 * // 注意:
 * //
 * //
 * // num 的长度小于 10002 且 ≥ k。
 * // num 不会包含任何前导零。
 * //
 * //
 * // 示例 1 :
 * //
 * //
 * //输入: num = "1432219", k = 3
 * //输出: "1219"
 * //解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * //
 * //
 * // 示例 2 :
 * //
 * //
 * //输入: num = "10200", k = 1
 * //输出: "200"
 * //解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * //
 * //
 * // 示例 3 :
 * //
 * //
 * //输入: num = "10", k = 2
 * //输出: "0"
 * //解释: 从原数字移除所有的数字，剩余为空就是0。
 * //
 * // Related Topics 栈 贪心算法
 * // 👍 535 👎 0
 *
 * @author: yuzicheng
 * @since: 3/29/21 8:21 下午
 */
public class RemoveKdigits {
    public static void main(String[] args) {
        RemoveKdigits k = new RemoveKdigits();
        System.out.println(k.removeKdigits("1432219", 3));
        System.out.println(k.removeKdigits("10", 1));
        System.out.println(k.removeKdigits("112", 1));
    }

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == k) {
            return "0";
        }
        int removeCount = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && removeCount < k) {
                stack.pop();
                removeCount++;
            }
            if (c == '0' && stack.isEmpty()) {
                // nothing
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty() && stringBuilder.length() != num.length() - k) {
            stringBuilder.append(stack.removeLast());
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
