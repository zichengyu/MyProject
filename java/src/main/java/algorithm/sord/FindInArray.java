package algorithm.sord;

import org.springframework.util.Assert;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：对角线上的数是其所在行和所在列形成的序列的中位数，不妨选取右上角的数作为比较基准，如果不相等，那么我们可以淘汰掉所有它左边的数或者它所有下面的
 */
public class FindInArray {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}};
        Assert.isTrue(Find(7, array));
        Assert.isTrue(Find(1, array));
        Assert.isTrue(!Find(17, array));
        Assert.isTrue(!Find(0, array));
        Assert.isTrue(!Find(0, new int[][]{}));
    }

    public static boolean Find(int target, int[][] arr) {
        //input check
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return false;
        }
        int i = 0, j = arr[0].length - 1;
        while (i != arr.length - 1 && j != 0) {
            if (target > arr[i][j]) {
                i++;
            } else if (target < arr[i][j]) {
                j--;
            } else {
                return true;
            }
        }

        return target == arr[i][j];
    }
}
