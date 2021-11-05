package BasicSortSolution.sort.sortPractice;

import Func.sort;

/**
 * Created by gump on 2021/7/11.
 */

/**
 *      最坏:O(n^2)
 *      最好:O(nlogn)
 *      平均:O(nlogn)
 */
public class QuickSort implements sort {

    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        quickSort(data,0,n-1);

        return data;
    }

    private void quickSort(int[] data, int l ,int r) {
        if (l<r){
            int p = partition(data,l,r);
            quickSort(data,l,p-1);
            quickSort(data,p+1,r);
        }
    }

    private int partition(int[] data,int l ,int r) {
        int pivot = data[r];
        int i = l-1;
        for (int j = l; j < r; j++) {
            if (data[j]<=pivot) {
                i++;
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }

        int tmp = data[r];
        data[r] = data[i+1];
        data[i+1] = tmp;
        return i+1;
    }

}
