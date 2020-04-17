package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/11 16:08
 * Comment:对于一个有正有负的整数数组，请找出最大的连续数列的和
 * 类似于贪心算法，即每一步都选择出局部最优解，从而得到整体最优解。
 */
public class FindMax {

    public static void main(String[] args) {
        int array[] = {5, -7, 20, -1, 1, -1, 2, -5};
        System.out.println(findMax(array));
    }

    public static int findMax(int[] arr) {
        //加上约束条件，防止当数组为空时造成数组越界
        if (arr.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0; //从当前位置重新计算
            }
            //当数组全为负数的时候只要有加法就一定比原来的数小,此时就相当于找出数组内最大的数
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}