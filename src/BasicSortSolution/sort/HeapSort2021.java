package BasicSortSolution.sort;

import Func.sort;

import java.util.Arrays;

/**
 * Created by gump on 2021/4/23.
 */
public class HeapSort2021 implements sort {


    @Override
    public int[] sort(int[] data) {

        for (int i = (data.length)/2 -1; i >=0 ; i--) {
            MaxHeapify(data,data.length,i);
        }
        return heapSort(data);
    }

    private int[] heapSort(int[] data) {
        for (int i = data.length-1; i >0;i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            MaxHeapify(data,i,0);
        }
        return data;
    }

    private void MaxHeapify(int[] data, int heapSize, int i) {
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);

        int largest = i;

        if (leftIndex < heapSize && data[leftIndex] >data[largest]){
            largest = leftIndex;
        }

        if (rightIndex< heapSize && data[rightIndex] > data[largest]){
            largest = rightIndex;
        }

        if (largest != i) {
            int temp = data[largest];
            data[largest] = data[i];
            data[i] = temp;
            MaxHeapify(data,heapSize,largest);
        }
        return;
    }

    private int getRightChildIndex(int i) {
        return (i<<1)+2;
    }

    private int getLeftChildIndex(int i) {
        return (i<<1)+1;
    }
}
