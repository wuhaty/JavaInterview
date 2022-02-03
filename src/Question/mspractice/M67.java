package Question.mspractice;

public class M67 {

    public static void main(String[] args) {
        M67 q = new M67();
        q.add(3,1);
    }


    public int add(int a, int b) {
        while (b != 0) {
            int c = (a&b)<<1;
            a = a^b;
            b =c;
        }

        return a;
    }


    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        int i = n-1,j=m-1,adder= 0;

        while (i>=0 || j >=0 || adder!=0){
            int l = i>=0? a.charAt(i)-'0':0;
            int r = j>=0? b.charAt(j)-'0':0;

            int sum = l+r+adder;
            adder = sum/2;
            sum%=2;

            sb.append(sum);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
