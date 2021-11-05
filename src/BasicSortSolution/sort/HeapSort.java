package BasicSortSolution.sort;

import Func.sort;

import java.util.Arrays;

/**
 * Created by txn on 17/3/18.
 * 堆排序
 * 时间复杂度:
 *      最坏:O(NlogN)
 *      最好:O(NlogN)
 *      平均:O(NlogN)
 * 空间复杂度:
 *      O(1)
 * 稳定性:
 *      不稳定
 */
public class HeapSort implements sort {

    public static void  main(String argc[]){
        HeapSort h = new HeapSort();
        int data[] = {5,6,2,1,4,3};
        System.out.println(Arrays.toString(h.sort(data)));
    }

    public int[] MaxHeapify(int data[],int heapSize,int index){
        int leftIndex = getLeftChild(index);
        int rightIndex = getRightChild(index);

        int largest = index;

        if(leftIndex <heapSize
                && data[leftIndex] > data[largest]){
            largest = leftIndex;
        }

        if(rightIndex <heapSize
                && data[rightIndex] > data[largest]){
            largest = rightIndex;
        }

        if(largest != index){
            int temp = data[index];
            data[index]=data[largest];
            data[largest] =temp;
            MaxHeapify(data,heapSize,largest);
        }
        return data;
    }

    public int getLeftChild(int i){
        return (i<<1)+1;
    }
    public int getRightChild(int i){
        return (i<<1)+2;
    }

    private int[] heapsort(int[] data) {
        for (int i = data.length -1 ; i > 0; i--) {
            int temp = data [i];
            data[i] = data[0];
            data[0] = temp;
            MaxHeapify(data,i,0);
        }
        return data;
    }

    @Override
    public int[] sort(int[] data) {
        //(data.length)/2 -1 the first non-leaf node


        for (int i = (data.length-1)/2; i >=0 ; i--) {
            MaxHeapify(data,data.length,i);
        }
        return heapsort(data);
    }
}
