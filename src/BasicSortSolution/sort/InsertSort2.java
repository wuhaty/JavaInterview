package BasicSortSolution.sort;

import Func.sort;

public class InsertSort2 implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (data[j] < data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }else {
                    break;
                }
            }
        }

        return data;
    }
}
