package BasicSortSolution.sort.sortPractice;

import Func.sort;

/**
 * Created by gump on 2021/7/11.
 */

/**
 * Best O(n)
 * Worst O(n^2)
 * Avg O(n^2)
 */

public class InsertSort implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int newCard = data[i];
            int j = i-1;
            while (j>=0 && data[j]>newCard) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = newCard;
        }
        return data;
    }
}
