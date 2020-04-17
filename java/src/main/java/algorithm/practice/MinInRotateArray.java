package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/3 10:31
 * Comment: 查找旋转数组中的最小元素
 */
public class MinInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (array[start] >= array[end]) {
            if (Math.abs(end - start) == 1) {
                mid = end;
                break;
            }
            mid = (end - start) / 2 + start;
            if (array[mid] == array[start] && array[mid] == array[end]) {
                return minInOrder(array);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }

        }
        return array[mid];
    }

    //如果三个数相等，则只能转为顺序遍历查找
    public static int minInOrder(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {6, 7, 8, 10, 15, 1, 3, 3, 5, 5, 6};
        int[] array3 = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array3));
    }
}