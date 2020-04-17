package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/6 9:15
 * Comment:
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    public static int NumberOf1_1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) == flag) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int NumberOf1_3(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int flag = 1;
        while (flag > 0) {
            flag = flag << 1;
            System.out.println(flag);
        }
        System.out.println(NumberOf1_1(213543));
        System.out.println(NumberOf1_3(213543));
    }
}