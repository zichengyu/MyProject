package algorithm.sort;

/**
 * User: 20160301301
 * Date: 2017/9/16 17:23
 * Comment: 归并排序
 * Descrirtion: 需要备用数组，一半一半的分部分 稳定排序
 */
public final class MergeSort {

    private static int[] aux;

    private MergeSort() {
    }

    public static void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (high - low) / 2 + low;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(int[] a, int low, int mid, int high) {
        aux = new int[a.length];
        for (int i = 0; i <= high; i++) {
            aux[i] = a[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 8, 10, 299, 5, 9, 14, 20, 66, 88, 92};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
