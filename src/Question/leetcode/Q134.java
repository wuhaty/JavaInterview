package Question.leetcode;

public class Q134 {

    public static void main(String[] args) {
        Q134 q = new Q134();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        q.canCompleteCircuit(gas,cost);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int amount = 0;
        int n = gas.length;
        for (int i = 0; i < n;) {
            amount = gas[i];
            int pre = i;
            int j =((i+1)%n);
            int count = 0;
            for (; j < n; j=((j+1)%n)) {
                if (amount<cost[pre]) break;
                amount -= cost[pre];
                amount += gas[j];
                pre = j;
                count++;
                if (j==i) return i;
            }
            i+= (count+1);
        }
        
        return -1;
    }
}
