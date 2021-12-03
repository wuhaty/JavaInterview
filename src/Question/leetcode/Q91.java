package Question.leetcode;

/**
 * Created by gump on 2017/4/9.
 */
public class Q91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int result[] = new int[s.length()];
        char sChar[] = s.toCharArray();
        result[0] = judge(0,sChar[0]-'0')?1:0;

        for(int i =1;i<s.length();i++){
            if(judge(sChar[i-1]-'0',sChar[i]-'0') && sChar[i-1]-'0' != 0){
                result[i] = ((i>1)?result[i-2]:1) + (judge(0,sChar[i]-'0')?result[i-1]:0);
            }else{
                if(sChar[i]=='0') result[i]=0;
                else
                    result[i] = result[i-1];
            }
        }

        return result[s.length()-1];
    }

    public boolean judge(int i ,int j){
        return (i*10+j) <= 26 && (i*10+j)>0;
    }


    public int numDecodings2021(String s) {
        char cs[] = s.toCharArray();
        int res[] = new int[s.length()];

        res[0] = judge2021(0,cs[0]-'0')? 1:0;

        for (int i = 1; i < s.length(); i++) {
            char c = cs[i];
            char pc = cs[i-1];

            if (pc != '0' && judge2021(pc-'0',c-'0')){
                res[i] = i>1?res[i-2]:1 + (judge2021(0,c-'0')? res[i-1]:0);
            }else {
                if (c == '0'){
                    res[i] = 0;
                }else {
                    res[i] = res[i-1];
                }
            }

        }
        return res[s.length()-1];
    }

    public boolean judge2021(int i,int j){
        return (i*10+j)<=26;
    }


    public static void main(String argc[]) {
        Q91 q =  new Q91();
        System.out.println(q.numDecodings2021("111111111111111111111111111111111111111111111"));
    }

    /**
     * 26 1 10 5 5 9 7 1 7 5 6 5 6 2
     * 26 1 10 5 5 9 7 17 5 6 5 6 2
     * 2 6 1 10 5 5 9 7 1 7 5 6 5 6 2
     * 2 6 1 10 5 5 9 7 17 5 6 5 6 2
     */
}
