package algorithm.practice;

import java.util.Arrays;

/**
 * User: 20160301301
 * Date: 2017/11/23 10:21
 * Comment: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int i = 0;
        int length = sequence.length;
        while (i < length && sequence[i] < sequence[length - 1]) {
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (sequence[j] > sequence[length - 1]) {
                return false;
            }
        }
        for (int j = i; j < length - 1; j++) {
            if (sequence[j] < sequence[length - 1]) {
                return false;
            }
        }
        boolean resultLeft = true;
        if (i > 0) {
            resultLeft = verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        boolean resultRight = true;
        if (i < length - 1) {
            resultRight = verifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
        }

        return (resultLeft && resultRight) ? true : false;
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{7,4,6,5};
        System.out.println(verifySquenceOfBST(sequence));
    }
}
