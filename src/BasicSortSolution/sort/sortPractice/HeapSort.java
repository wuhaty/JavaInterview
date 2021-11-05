package BasicSortSolution.sort.sortPractice;

import Func.sort;

/**
 * Created by gump on 2021/7/11.
 */

/**
 *  最坏:O(NlogN)
 *  最好:O(NlogN)
 *  平均:O(NlogN)
 */
public class HeapSort implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;

        for (int i = (n/2)-1; i >=0 ; i--) {
            heapify(data,i,data.length);
        }

        for (int i = n-1; i >0 ; i--) {
            Integer tmp = data[0];
            data[0] = data[i];
            data[i] = tmp;

            heapify(data,0,i);
        }

        return data;
    }

    private void heapify(int[] data, int i, int heapSize) {
        int leftChild = getLeftIndex(i);
        int rightChild = getRightIndex(i);

        int largest = i;

        if (leftChild < heapSize && data[leftChild] > data[i]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && data[rightChild] > data[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int tmp = data[i];
            data[i] = data[largest];
            data[largest] = tmp;
            heapify(data,largest,heapSize);
        }

    }

    private int getRightIndex(int i) {
        return (i<<1) +2;
    }

    private int getLeftIndex(int i) {
        return (i<<1) +1;
    }
}
