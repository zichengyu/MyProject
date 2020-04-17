package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/9/9 14:33
 * 标题：二维数组中的查找
 * 描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class QueryInTwoDimensionalArray {


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7, 9},
                {2, 3, 6, 8, 10},
                {3, 4, 7, 9, 11}}; //定义一个二维数组
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(find(4, arr));

    }

        public static boolean find(int target, int[][] array) {
            if (array == null) {
                return false;
            }
            int columns = array[0].length; //宽度
            int rows = array.length;   //高度
            if (rows > 0 && columns > 0) {
                int row = 0;
                int column = columns - 1;
                while (row < rows && column > 0) {
                    if (array[row][column] > target) {
                        column--;
                    }
                    if (array[row][column] == target) {
                        return true;
                    }
                    if (array[row][column] < target) {
                        row++;
                    }
                }
            }
            return false;
        }
}
