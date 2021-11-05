package BasicSortSolution.sort;

import Func.sort;

public class QuickSort2 implements sort {
    @Override
    public int[] sort(int[] data) {
        quickSort(data, 0, data.length-1);
        return data;
    }

    private void quickSort(int[] data, int l, int r) {
        if (l>=r) return;

        int i = l , j = r;
        int key = data[l];

        while (i<j) {
            while (i<j && data[j] >= key) j--;
            if (i<j) {
                data[i] = data[j];
                i++;
            }

            while (i<j && data[i] < key) i++;
            if (i<j) {
                data[j] = data[i];
                j--;
            }
        }

        data[i] = key;
        quickSort(data,l,i-1);
        quickSort(data,i+1,r);
    }
}
