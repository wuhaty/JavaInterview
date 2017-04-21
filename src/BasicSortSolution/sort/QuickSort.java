package BasicSortSolution.sort;

import Func.sort;

/**
 * Created by txn on 17/3/18.
 * 快速排序
 * 时间复杂度:
 *      最坏:O(n^2)
 *      最好:O(nlogn)
 *      平均:O(nlogn)
 * 空间复杂度:
 *      O(nlogn)
 * 稳定性:
 *      不稳定
 */
public class QuickSort implements sort {
    @Override
    public int[] sort(int[] data) {
        quickSort(data,0,data.length-1);
        return data;
    }

    private void quickSort(int[] data, int p, int r) {
        if(p<r){
            int q = partition(data,p,r);
            quickSort(data,p,q-1);
            quickSort(data,q+1,r);
        }
    }

    private int partition(int[] data, int p, int r) {
        int x = data[r];
        int i = p-1;
        int j = p;
        int temp;
        for (; j < r; j++) {
            if(data[j]<x){
                temp = data [i+1];
                data [i+1] = data [j];
                data[j] =temp;
                i++;
            }
        }
        temp = data [r];
        data[r] = data [i+1];
        data[i+1] =temp;

        return i+1;
    }
}
