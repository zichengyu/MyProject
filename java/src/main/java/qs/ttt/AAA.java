package qs.ttt;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/10/21 11:18 上午
 */
public class AAA {
    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        maxProfit(new int[]{1,4,2});
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = prices.length - 1;
        while(left < right) {
            if(prices[left] < min) {
                min = prices[left];
            }
            if(prices[right] > max) {
                max = prices[right];
            }
            left++;
            right--;
        }
        return Math.max(0, max - min);
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
