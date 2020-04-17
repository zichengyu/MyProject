package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/4 11:35
 * Comment:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n)=2f(n-1)
 */
public class JumpFloorII {

    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return (int) (Math.pow(2, target - 1));
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
}