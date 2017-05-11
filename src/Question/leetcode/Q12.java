package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q12 {

    String alph[] ={"I","V","X","L","C","D","M"};
    int nums[] = {1,5,10,50,100,500,1000};


    public static void main(String argc[]){
        Q12 q =new Q12();
        System.out.println(q.intToRoman(3834));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String M[] = {"" ,"M","MM","MMM"};
        String C[] = {"" ,"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String X[] = {"" ,"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String I[] = {"" ,"I","II","III","IV","V","VI","VII","VIII","IX"};

        return sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[(num%10)]).toString();
    }

        public String intToRomanOriTlE(int num) {
        StringBuilder sb = new StringBuilder();
        while (num>0){
            int i = nums.length-1;
            while (i>=0 && nums[i]>num){
                i--;
            }

            int j = i/2*2;

            while (i+1< nums.length && j>=0){
                if(nums[i+1] - nums[j] <=num){
                    break;
                }else{
                    j-=2;
                }
            }

            if(j<nums.length && i!=(nums.length-1) && j>=0){
                num-=(nums[i+1]-nums[j]);
                sb.append(alph[j]).append(alph[i+1]);
            }else{
                num-=nums[i];
                sb.append(alph[i]);
            }
        }

        return sb.toString();
    }
}
