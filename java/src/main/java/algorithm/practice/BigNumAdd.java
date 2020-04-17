package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/7 11:33
 * 1.反转两个字符串，便于从低位到高位相加和最高位的进位导致和的位数增加；
 * 2.对齐两个字符串，即短字符串的高位用‘0’补齐，便于后面的相加；
 * 3.把两个正整数相加，一位一位的加并加上进位。
 */
public class BigNumAdd {
    /**
     * 用字符串模拟两个大数相加
     *
     * @param n1 加数1
     * @param n2 加数2
     * @return 相加结果
     */
    public static String add2(String n1, String n2) {
        StringBuffer result = new StringBuffer();

        int len1 = n1.length();
        int len2 = n1.length();
        int maxLen = len1 > len2 ? len1 : len2;
        //2.把两个字符串补齐，即短字符串的高位用0补齐
        n1 = changeLength(n1, maxLen);
        n2 = changeLength(n2, maxLen);
        boolean nOverFlow = false; //是否越界
        int nTakeOver = 0; //溢出数量
        //3.把两个正整数相加，一位一位的加并加上进位
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + nTakeOver;

            if (nSum >= 10) {
                if (i == (maxLen - 1)) {
                    nOverFlow = true;
                }
                nTakeOver = 1;
                result.append(nSum - 10);
            } else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }
        //如果溢出的话表示位增加了
        if (nOverFlow) {
            result.append(nTakeOver);
        }
        return result.reverse().toString();
    }

    public static String changeLength(String n, int maxLength) {
        //1、反转字符串
        StringBuffer sb = new StringBuffer(n).reverse();
        for (int i = 0; i < maxLength - n.length(); i++) {
            sb.append("0");
        }
        n = sb.toString();
        return n;
    }

    public static void main(String[] args) {
        String str = add2("9117", "123");
        System.out.println(str);
    }
}