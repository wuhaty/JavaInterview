package BasicSortSolution;

import Func.sort;

/**
 * Created by txn on 17/3/18.
 * 合并排序
 * 时间复杂度:
 *      最坏:O(nlogn)
 *      最好:O(nlogn)
 *      平均:O(nlogn)
 * 空间复杂度:
 *      O(n)
 * 稳定性:
 *      稳定
 */
public class MergeSort implements sort {
    @Override
    public int[] sort(int[] data) {
        mergeSort(data,0,data.length-1);
        return data;
    }

    private void mergeSort(int[] data, int p, int r) {
        int q;
        if (p<r){
            q = (p+r)/2;
            mergeSort(data,p,q);
            mergeSort(data,q+1,r);
            merge(data,p,q,r);
        }
    }

    private void merge(int[] data, int p, int q, int r) {
        int i=0,j=0;

        int left[] = new int[q-p+1];
        int right[] = new int[r-q];

        for (int k = 0; k <=q-p; k++) {
            left[k] =data[k+p];
        }

        for (int k = 0; k <=r-q-1; k++) {
            right[k] =data[q+k+1];
        }
        
        for (int k = p; k <= r; k++) {
            if (j>=right.length ){
                data[k] = left[i];
                i++;
                continue;
            }

            if (i>=left.length ){
                data[k] = right[j];
                j++;
                continue;
            }

            if(left[i]<=right[j]){
                data[k] = left[i];
                i++;
            }else{
                data[k] = right[j];
                j++;
            }
        }
    }
}
