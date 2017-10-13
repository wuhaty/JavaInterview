package Question.leetcode;

public class Q537 {

    public static void main(String argc[]){
        Q537 q = new Q537();
        System.out.println(q.complexNumberMultiply("1+-1i","1+-1i"));
    }

    public String complexNumberMultiply(String a, String b) {

        //(a+bi)(c+di) = ac + (ad+bc)i -bd

        int ar = 0, br = 0;
        int ac = 0, bc = 0;
        int ai = a.indexOf("+");
        int bi = b.indexOf("+");


        ar = Integer.parseInt(a.substring(0,ai));
        br = Integer.parseInt(b.substring(0,bi));

        ac = Integer.parseInt(a.substring(ai+1,a.indexOf("i")));
        bc = Integer.parseInt(b.substring(bi+1,b.indexOf("i")));

        return Integer.toString(ar * br - ac * bc) + "+" + Integer.toString(ar * bc + ac * br) + "i";
    }
}
