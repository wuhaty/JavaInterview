package BasicSortSolution;

import Func.sort;

/**
 * Created by txn on 17/3/18.
 * 选择排序
 * 时间复杂度:
 *      最坏:O(n^2)
 *      最好:O(n^2)
 *      平均:O(n^2)
 * 空间复杂度:
 *      O(1)
 * 稳定性:
 *      不稳定
 */
public class SelectionSort implements sort {

    @Override
    public int[] sort(int[] data) {
        int temp = 0;
        int min = 0;

        for (int i = 0; i < data.length; i++) {
            min = i;
            for (int j = i; j < data.length; j++) {
                if(data[j]<data[min]){
                    min=j;
                }
            }
            temp = data[i];
            data[i] = data[min];
            data[min] =temp;
        }
        

        return data;
    }
}
