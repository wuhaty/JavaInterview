package BasicSortSolution.sort;

import Func.sort;

public class HeapSort2 implements sort {
    @Override
    public int[] sort(int[] data) {

        int n = data.length-1;
        for (int i = n/2; i >= 0 ; i--) {
            maxHeapify(data,i,n);
        }

        for (int i = n; i >0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            maxHeapify(data,0,i-1);
        }

        return data;
    }

    private void maxHeapify(int[] data, int i, int n) {
        int left = (i<<1) +1;
        int right = left +1;
        int max = left;

        if (left > n ) return;

        if (right <= n && data[right] > data[left]) {
            max = right;
        }

        if (data[max] > data[i]) {
            int temp = data[i];
            data[i] = data[max];
            data[max] = temp;

            maxHeapify(data,max,n);
        }
    }
}
