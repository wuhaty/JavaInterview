package BasicSortSolution.sort;

import Func.sort;

public class SelectionSort2 implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
        return data;
    }
}
