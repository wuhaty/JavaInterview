package BasicSortSolution.sort;

import Func.sort;

/**
 * Created by txn on 17/3/18.
 * 希尔排序
 * 时间复杂度:
 *      最坏:O(n^2)
 *      最好:O(n)
 *      平均:O(n^1.3)
 * 空间复杂度:
 *      O(1)
 * 稳定性:
 *      不稳定
 */
public class ShellSort implements sort {
    @Override
    public int[] sort(int[] data) {
        for (int gap = data.length/2; gap > 0; gap/=2) {
            for (int i = gap; i <data.length ; i++) {
                int temp = data[i];
                int j;
                for (j= i-gap; j >=0 && data[j]>temp; j -= gap) {
                    data[j+gap] = data[j];
                }
                data[j+gap]=temp;
            }
        }
        return data;
    }
}
