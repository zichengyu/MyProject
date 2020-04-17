package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/4 10:42
 * Comment:
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonacci {

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result  = 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(35));
    }
}