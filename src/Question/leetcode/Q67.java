package Question.leetcode;

/**
 * Created by gump on 2017/5/10.
 */
public class Q67 {
    public static void main(String argc[]){
        Q67 q = new Q67();
        System.out.println(q.addBinary("111","111"));
    }


    public String addBinary(String a, String b) {
        char as[] = a.toCharArray();
        char bs[] = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int charge = 0;

        int i = a.length()-1;
        int j = b.length()-1;

        while (i>=0 || j>=0){
            int tempa = i>=0?(as[i]-'0') :0;
            int tempb = j>=0?(bs[j]-'0') :0;


            int result = (tempa ^ tempb)+charge;

            if(result >1){
                result = 0;
                charge = 1;
            }else if(tempa == 1 && tempb == 1){
                charge = 1;
            }else {
                charge = 0;
            }
            sb.insert(0,result);
            i--;
            j--;
        }
        if (charge>0) sb.insert(0,charge);
        return sb.toString();
    }
}
