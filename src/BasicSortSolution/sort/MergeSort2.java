package BasicSortSolution.sort;

import Func.sort;

import java.util.Arrays;

public class MergeSort2 implements sort {
    @Override
    public int[] sort(int[] data) {
        mergeSort(data,0,data.length-1);
        return data;
    }

    private void mergeSort(int[] data, int l, int r) {
        if (l<r){
            int mid = (l+r)/2;
            mergeSort(data,l,mid);
            mergeSort(data,mid+1,r);
            merge(data,l,mid,r);
        }
    }

    private void merge(int[] data, int l, int mid, int r) {
        int[] left = Arrays.copyOfRange(data,l,mid+1);
        int[] right = Arrays.copyOfRange(data,mid+1,r+1);
        int i=0,j=0,k=0;

        while (i<left.length && j< right.length){
            if (left[i]<=right[j]){
                data[l+k] = left[i];
                i++;
            }else {
                data[l+k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            data[l+k] = left[i];
            k++;
            i++;
        }
        while(j<right.length){
            data[l+k] = right[j];
            k++;
            j++;
        }
    }

}
