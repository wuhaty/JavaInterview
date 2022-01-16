package Question.sword;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class O45 {
    public static void main(String[] args) {
        O45 q = new O45();
        int[] n = new int[]{10,2};
        q.minNumberQuickSort(n);
    }


    public String minNumber(int[] nums) {
        PriorityQueue<String> q = new PriorityQueue<>((s1,s2) -> (s1+s2).compareTo(s2+s1));
        q.addAll(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            sb.append(q.poll());
        }
        return sb.toString();
    }

    public String minNumberQuickSort(int[] nums) {
        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quickSort(strs,0,strs.length-1);

        StringBuilder sb = new StringBuilder();
        for (String s:strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l>=r) return;

        String tmp = strs[l];
        int i = l;
        int j = r;
        while (i<j){
            while (i<j && (strs[j]+strs[l]).compareTo(strs[l]+strs[j]) >= 0) j--;
            while (i<j && (strs[i]+strs[l]).compareTo(strs[l]+strs[i]) <= 0) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }

        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs,l,i-1);
        quickSort(strs,i+1,r);
    }
}
