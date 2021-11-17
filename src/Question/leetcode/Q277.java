package Question.leetcode;

public class Q277 {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (candidate!= i && knows(candidate,i)){
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (knows(candidate,i)) return -1;
            if (!knows(i,candidate)) return -1;
        }
        return candidate;
    }

    public boolean knows(int a, int b){
        //mock function
        return true;
    }
}
