package Question.leetcode;

/**
 * Created by gump on 2017/4/21.
 */
public class Q43 {
    public String multiply(String num1, String num2) {
        int result[] = new int[num1.length()+num2.length()];


        for (int i = num1.length()-1; i >=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                result[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        int adder =0;

        for (int i = result.length-1; i >=0 ; i--) {
            int temp =(result[i]+adder);
            result[i] = temp%10 ;
            adder = temp /10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i:result) {
            sb.append(i);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {
        Q43 q = new Q43();
        q.multiplyExample("9133","0");
    }

    public String multiplyExample(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

    public String multiply2021(String num1, String num2) {
        char cs1[] = num1.toCharArray();
        char cs2[] = num2.toCharArray();
        StringBuilder sb = new StringBuilder();

        int[] temp = new int[cs1.length+cs2.length];

        for (int i = cs1.length-1; i >=0; i--) {
            int n1 = cs1[i] - '0';

            for (int j = cs2.length - 1; j >= 0; j--) {
                int n2 = cs2[j] - '0';
                temp[j+i+1] += n1*n2;
            }
        }

        for (int i = temp.length-1; i >0; i--) {
            temp[i-1] += (temp[i]/10);
            temp[i] = temp[i]%10;
        }

        int index = 0;
        if (temp[0]==0) index++;

        while (index<temp.length){
            sb.append(temp[index]);
            index++;
        }
        return sb.toString();
    }

//    public static void main(String argc[]){
//        Q43 q = new Q43();
//        System.out.println(q.multiply("9","99"));
//    }
}
