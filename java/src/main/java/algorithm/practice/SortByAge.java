package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/3 10:24
 * Comment: 按年龄排序
 */
public class SortByAge {
    public static void main(String[] args) throws Exception {
        int[] ages = {1, 8, 10, 35, 78, 95, 15, 35, 95, 75, 15, 15, 35, 10, 13, 31, 35, 75, 35, 85, 95, 25, 15};
        sortAge(ages, ages.length);
    }

    public static void sortAge(int[] ages, int length) {
        if (ages == null || length <= 0) {
            return;
        }
        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) {
                return;
            }
            timesOfAge[age]++;
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
}