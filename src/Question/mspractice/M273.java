package Question.mspractice;

public class M273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        M273 q = new M273();
        q.numberToWords(1234567890);
    }

    public String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 3,unit = 1000000000; i >=0; i--,unit/=1000) {
            int v = num/unit;
            if (v>0){
                num-= v * unit;
                StringBuilder curr = new StringBuilder();
                recursion(v,curr);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }

        return sb.toString().trim();
    }

    private void recursion(int n, StringBuilder curr) {
        if (n == 0) {
            return;
        }

        if (n<=9){
            curr.append(singles[n]).append(" ");
            return;
        }else if (n<20){
            curr.append(teens[n-10]).append(" ");
            return;
        }else if (n<100){
            curr.append(tens[n/10]).append(" ");
            recursion(n%10,curr);
        }else {
            curr.append(singles[n/100]).append(" Hundred ");
            recursion(n%100,curr);
        }
    }
}
