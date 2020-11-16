package BasicSortSolution.sort;

import Func.sort;

public class BubbleSort2 implements sort {

    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = n-1 ; j > i ; j--) {
                if (data[j] < data[j-1]) {
                    int temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }

        return data;
    }
}
