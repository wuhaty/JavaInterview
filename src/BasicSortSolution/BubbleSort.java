package BasicSortSolution;

import Func.sort;

/**
 * Created by txn on 17/3/18.
 * 冒泡排序
 * 时间复杂度:
 *      最坏:O(n^2)
 *      最好升序:O(n)
 *      平均:O(n^2)
 * 空间复杂度:
 *      O(1)
 * 稳定性:
 *      稳定
 */
public class BubbleSort implements sort {
    @Override
    public int[] sort(int[] data) {
        int temp;
        for (int i = data.length-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(data[j+1]<data[j]){
                    temp =data[j];
                    data[j] =data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data;
    }
}
