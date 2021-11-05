package Question.leetcode;

/**
 * Created by gump on 2021/6/27.
 */
public class Q273 {

    String one[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String two[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String three[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};


    public static void main(String[] args) {
        Q273 q = new Q273();
        q.numberToWords(1000);
    }

    public String numberToWords(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int n = c.length;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = n-1; i >=0 ; i-=3) {

            String s = convert((i-2)>=0?c[i-2]:null,(i-1)>=0?c[i-1]:null,c[i]);
            switch (count) {
                case 1:
                    s+= s.isEmpty()? "":" Thousand ";
                    break;
                case 2:
                    s+= s.isEmpty()? "":" Million ";
                    break;
                case 3:
                    s+= s.isEmpty()? "":" Billion ";
                    break;
            }

            sb.insert(0,s);
            count ++;
        }
        return sb.toString().trim();
    }

    private String convert(Character c, Character c1, Character c2) {
        StringBuilder sb = new StringBuilder();

        Integer i = null;
        Integer i2 = null;

        if (c1 != null) {
            i = (c1-'0');
        }

        if (c2 != null) {
            i2 = (c2-'0');
        }

        if (c != null) {
            Integer h = (c-'0');
            if (h!= 0) {
                if ((i!=null && i==0) && (i2!=null&&i2==0)){
                    sb.append(one[h]+" Hundred");
                }else{
                    sb.append(one[h]+" Hundred ");
                }
            }
        }



        if (i != null && i == 1) {
            sb.append(two[i2]);
        }else if (i2 != null && i != null && i!=0){
            if (i2 == 0){
                sb.append(three[i]);
            }else{
                sb.append(three[i] + " " + one[i2]);
            }
        }else if (i2 != null) {
            if (c==null && c1 == null && c2 =='0') {
                sb.append("Zero");
            }else if (i2 != 0){
                sb.append(one[i2]);
            }
        }


        return sb.toString();
    }
}
