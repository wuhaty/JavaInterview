package solution;

import func.sort;

/**
 * Created by txn on 17/3/18.
 * 插入排序
 * 时间复杂度:
 *      最坏:完全逆序O(n^2)
 *      最好:有序O(n)
 *      平均:O(n^2)
 * 空间复杂度:
 *      O(1)
 * 稳定性:
 *      稳定
 */
public class InsertSort implements sort {

    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i <data.length ; i++) {
            int newCard = data[i];

            int j = i-1;
            while(j >= 0 &&
                    data[j]>newCard){
                data[j+1] = data[j];
                j-- ;
            }
            data[j+1] = newCard;
        }
        return data;
    }
}
