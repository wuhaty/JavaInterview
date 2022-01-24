package Question.sword;

public class O43 {
    public int countDigitOne(int n) {
        int high = n /10, low = 0;
        int digit = 1;
        int res = 0;
        int cur = n %10;

        while (high != 0 || low != 0){
            if (cur == 0) res += (high * digit);
            else if (cur == 1) res += (high * digit + low +1);
            else res += ((high + 1) * digit);

            low += cur * digit;
            cur = high % 10;
            high /=10;
            digit *=10;
        }

        return res;
    }
}
