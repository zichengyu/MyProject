package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/8 10:23
 * Comment:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] tmp = new int[array.length];
        int temLength = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) == 1) {
                tmp[temLength++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) != 1) {
                tmp[temLength++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 2, 1};
        reOrderArray(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(2 & 0x01);
    }
}