package algorithm.sort;

import algorithm.algs4.StdOut;

/**
 * User: 20160301301
 * Date: 2017/9/7 19:29
 * Comment:
 */
public class Example {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * 选择排序:从剩余元素中选择最小的并交换
     * 比较：n^2/2 交换：n
     */
    public static void selectSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = min; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    /**
     * 插入排序：将每一个新元素插入到有序的序列中
     * 逆序 比较：n^2/2 交换：n^2/2
     * 正序 比较：n-1   交换：0
     * 平均 比较：n^2/4 交换：n^2/4
     */
    public static void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "TestSerialize", "E", "X", "A", "M", "P", "L", "E"};
        selectSort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}