package Question.sword;

public class O44 {

    public static void main(String[] args) {
        O44 q = new O44();
        q.findNthDigit(11);
    }


    public int findNthDigitTLE(int n) {
        int count = 0;
        int cur = 0;
        while (true){
            String str = String.valueOf(cur);
            for (char c:str.toCharArray()) {
                if (count == n){
                    return c-'0';
                }
                count++;
            }
            cur++;
        }
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (count < n){
            n-=count;
            start*=10;
            digit++;
            count = digit*start*9;
        }

        long num = start+(n-1)/digit;

        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
