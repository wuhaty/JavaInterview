package BasicSortSolution.sort;

import Func.sort;

public class HeapSortOPT implements sort {


    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = n/2-1; i >=0; i--) {
            heapify(data,i,n);
        }

        for (int i = n-1; i > 0; i--) {
            int t = data[i];
            data[i] = data[0];
            data[0] = t;
            heapify(data,0,i);
        }

        return data;
    }

    private void heapify(int[] data, int i, int heapSize) {
        int temp = data[i];

        for (int k = 2*i+1; k < heapSize; k = 2*k+1) {
            if (k+1 < heapSize && data[k+1] > data[k]){
                k++;
            }

            if (data[k] > temp){
                data[i] = data[k];
                i = k;
            }else {
                break;
            }
        }

        data[i] = temp;
    }
}
