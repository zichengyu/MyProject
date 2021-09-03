package algorithm.sort;

/**
 * User: 20160301301
 * Date: 2017/9/16 17:23
 * Comment: 归并排序
 * Descrirtion: 需要备用数组，一半一半的分部分 稳定排序
 */
public final class MergeSort {

    private MergeSort() {
    }

    private static void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid, temp);
        mergeSort(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }

    private static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int t = start;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[t++] = array[left++];
            } else {
                temp[t++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[t++] = array[left++];
        }
        while (right <= end) {
            temp[t++] = array[right++];
        }
        for (t = start; t <= end; t++) {
            array[t] = temp[t];
        }
    }


    public static void main(String[] args) {
        int array[] = {2, 7, 8, 10, 299, 5, 9, 14, 20, 66, 88, 92};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
