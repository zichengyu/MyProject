package algorithm.sort;

import static algorithm.sort.Example.exch;

/**
 * User: 20160301301
 * Date: 2017/10/28 13:52
 * Comment: 快速排序 分部分但是随机分，不用备用数组，不稳定排序
 */
public final class QuickSort {

    private QuickSort() {
    }

    /**
     * @param a can
     */
    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partitionNormal(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * @param a
     * @param lo
     * @param hi
     */
    public static int partitionNormal(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            //大
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            //小
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    //三向切分快排
    public static void sort3(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] array = new String[]{"E", "A", "E", "C", "J", "D", "R", "G"};
        sort3(array, 0, array.length - 1);
        for (String str : array) {
            System.out.print(str + "\t");
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int point = array[start];
        while (left <= right) {
            while (left <= right && array[left] < point) {
                left++;
            }
            while (left <= right && array[right] > point) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(array, start, left);
        quickSort(array, right, end);
    }
}
