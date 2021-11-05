package Question.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by gump on 2021/8/25.
 */
public class Q632 {

    public static void main(String[] args) {
        Q632 q =new Q632();

        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        List<List<Integer>> input = new LinkedList<>();
        input.add(l);
        input.add(l);
        input.add(l);

        q.smallestRange2021(input);
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int min = Integer.MAX_VALUE;
        int length = Integer.MAX_VALUE;
        int res[] = new int[2];
        int[] index = new int[nums.size()];

        while (true){
            int minIndex = 0;
            int maxIndex = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i).get(index[i]) < nums.get(minIndex).get(index[minIndex])) {
                    minIndex = i;
                }
                if (nums.get(i).get(index[i]) > nums.get(maxIndex).get(index[maxIndex])) {
                    maxIndex = i;
                }
            }

            int minIndexVal = nums.get(minIndex).get(index[minIndex]);
            int maxIndexVal = nums.get(maxIndex).get(index[maxIndex]);

            int s = Math.min(length,maxIndexVal-minIndexVal);

            if (s==length && min<minIndexVal) {
            }else if (s<length){
                min = Math.min(min, minIndexVal);
                length = s;

                res[0] = minIndexVal;
                res[1] = maxIndexVal;
            }

            index[minIndex] ++;

            if (index[minIndex] >= nums.get(minIndex).size()) return res;

        }
    }

    public int[] smallestRange2021(List<List<Integer>> nums){
        int n = nums.size();
        int next[] = new int[n];
        int res[] = new int[2];
        int max = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o).get(next[o])));

        for (int i = 0; i < n; i++) {
            q.offer(i);
            max = Math.max(max,nums.get(i).get(0));
        }

        while(true) {
            int min = q.poll();
            int range = max - nums.get(min).get(next[min]);

            if (range < minRange) {
                minRange = range;
                res[0] = nums.get(min).get(next[min]);
                res[1] = max;
            }
            next[min] ++;

            if (next[min] == nums.get(min).size()){
                break;
            }

            q.offer(min);
            max = Math.max(max, nums.get(min).get(next[min]));
        }

        return res;
    }
}
