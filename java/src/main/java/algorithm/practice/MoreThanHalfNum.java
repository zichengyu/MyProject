package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/12/1 9:29
 * Comment:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array1 = new int[]{1, 2, 3, 2, 4, 2, 5, 3, 3};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        //System.out.println(moreThanHalfNum.solution1(array));
        System.out.println(moreThanHalfNum.solution1(array1));
    }

    /**
     * 数组中出现数目大于一半的数存在，最终一定times>1
     */
    public int solution1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int times = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            }
            if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        boolean flag = chackMoreThanHalf(array, result);
        if (!flag) {
            return 0;
        }

        return result;
    }

    boolean chackMoreThanHalf(int[] array, int num) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            }
        }
        if (2 * times > array.length) {
            return true;
        } else {
            return false;
        }
    }
}
