package BasicSortSolution.sort.sortPractice;

import Func.sort;

/**
 * Created by gump on 2021/7/11.
 */


// worst O(n^2)
// best O(n)
// Avg O(n^2)
public class BubbleSort implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (data[j] > data[j+1]) {
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }

        return data;
    }
}
