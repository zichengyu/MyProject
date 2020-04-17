package algorithm.practice;

import java.util.ArrayList;

/**
 * User: 20160301301
 * Date: 2017/11/13 15:44
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        int rows = matrix.length;
        int colums = matrix[0].length;
        if (colums == 0) {
            return result;
        }
        int layers = (Math.min(rows, colums) - 1) / 2 + 1; //这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < colums - i; k++) result.add(matrix[i][k]); //左至右
            for (int j = i + 1; j < rows - i; j++) result.add(matrix[j][colums - i - 1]); //右上至右下
            for (int k = colums - i - 2; (k >= i) && (rows - i - 1 != i); k--) result.add(matrix[rows - i - 1][k]); //右至左
            for (int j = rows - i - 2; (j > i) && (colums - i - 1 != i); j--) result.add(matrix[j][i]); //左下至左上
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int row = matrix.length;
        int collor = matrix[0].length;
        int circle = (Math.min(row, collor) - 1) / 2 + 1;
        ArrayList<Integer> r = printMatrix(matrix);
        for (int i : r) {
            System.out.println(i);
        }
        System.out.println(circle);
    }
}