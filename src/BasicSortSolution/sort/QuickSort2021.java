package BasicSortSolution.sort;

import Func.sort;

/**
 * Created by gump on 2021/4/23.
 */
public class QuickSort2021 implements sort {

    @Override
    public int[] sort(int[] data) {
        quickSort(data,0,data.length-1);
        return data;
    }

    private void quickSort(int[] data, int p, int q) {
        if (p<q){
            int pos = partition(data,p,q);
            quickSort(data,p,pos-1);
            quickSort(data,pos+1,q);
        }
    }

    private int partition(int[] data, int p, int q) {
        int i = p; //track the last element which less than data[q]

        for (int j = p; j < q; j++) {
            if (data[j]<data[q]){
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
            }
        }

        int t = data[q];
        data[q] = data[i];
        data[i] = t;
        return i;
    }
}
