package Question.mspractice;

public class M415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1.length()-1,j = num2.length()-1,adder = 0;

        while (i>=0 || j >= 0 || adder > 0) {
            int l = i>=0? (int) num1.charAt(i)-'0':0;
            int r = j>=0? (int) num2.charAt(j)-'0':0;

            int sum = l + r + adder;
            if (sum>=10){
                adder = 1;
            }else {
                adder = 0;
            }

            sb.append(sum%10);
            i--;
            j--;
        }

        sb.reverse();
        return sb.toString();
    }
}
