package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/4 11:13
 * Comment:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class JumpFloor {

    public static int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int result = 0;
        int first = 1;
        int second = 1;
        for (int i = 2; i <= target; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(2));
    }
}