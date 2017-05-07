package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q28 {
    public int strStrOri(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStrKMP(String haystack, String needle) {
        int next[] = new int[needle.length()];
        int j =0;
        for (int i = 1; i < next.length; i++) {
            if(haystack.charAt(i) == needle.charAt(j)){
                next[i] = j+1;
                j++;
                continue;
            }else{
                if(j==0){
                    continue;
                }

                while (j>=0 && haystack.charAt(i) != needle.charAt(j)){
                    j=next[j-1];
                }

                if(haystack.charAt(i) == needle.charAt(j)){
                    next[i] = j+1;
                    j++;
                    continue;
                }else{
                    continue;
                }
            }
        }

        int ori=0,tar=0;

        while (ori<haystack.length() && tar<needle.length()){
            if(haystack.charAt(ori) == needle.charAt(tar)){
                ori++;tar++;
            }else{
                if(tar == 0){
                    ori++;continue;
                }else{
                    tar = next[tar-1];
                }
            }
        }
        return tar>=needle.length()?ori-needle.length()+1:-1;
    }
}
