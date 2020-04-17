package algorithm.practice;

import java.util.Stack;

/**
 * User: 20160301301
 * Date: 2017/11/22 9:54
 * Comment:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stackDate = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stackDate.push(pushA[i]);
            while (index < popA.length && stackDate.peek() == popA[index]) {
                stackDate.pop();
                index++;
            }
        }
        if (stackDate.isEmpty()) {
            return true;
        }
        return false;
    }
}
