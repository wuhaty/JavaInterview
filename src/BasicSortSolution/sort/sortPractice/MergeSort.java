package BasicSortSolution.sort.sortPractice;

import Func.sort;

/**
 * Created by gump on 2021/7/11.
 */

/**
 * Worst: O(nlogn)
 * Best: O(nlogn)
 * Avg: O(nlogn)
 *
 * Space: O(n)
 */
public class MergeSort implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        mergeSort(data,0,n-1);

        return data;
    }

    private void mergeSort(int[] data, int l, int r) {
        if (l<r) {
            int mid = (l+r)/2;
            mergeSort(data,l,mid);
            mergeSort(data,mid+1,r);
            merge(data,l,mid,mid+1,r);
        }
    }

    private void merge(int[] data, int l1, int r1, int l2, int r2) {
        int k = l1;
        int p=0,q=0;
        int left[] = new int[r1-l1+1];
        int right[] = new int[r2-l2+1];

        for (int i = 0; i <=(r1-l1) ; i++) {
            left[i] = data[l1+i];
        }

        for (int i = 0; i <=(r2-l2) ; i++) {
            right[i] = data[l2+i];
        }

        while (p<=(r1-l1) && q<=(r2-l2)){
            if (left[p] < right[q]) {
                data[k++] = left[p++];
            }else {
                data[k++] = right[q++];
            }
        }

        while (p<=(r1-l1)) {
            data[k++] = left[p++];
        }

        while (q<=(r2-l2)) {
            data[k++] = right[q++];
        }
    }
}
