package algorithm.sord;

import org.springframework.util.Assert;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int lie = array[0].length;
        int hang = array.length;
        int column = lie - 1;
        int row = 0;
        while (row < hang && column >= 0) {
            int value = array[row][column];
            if (target > value) {
                row++;
            } else if (target < value) {
                column--;
            } else {
                return true;
            }
        }
        return false;
    }
}
