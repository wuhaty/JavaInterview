package BasicSortSolution.string;

import java.util.Random;

/**
 * Created by gump on 2017/4/21.
 */
public class kmp {

    public static Random random = new Random();

    public static String randomStr(){
        StringBuilder sb = new StringBuilder();
        int i = 100;
        while (i-- >0){
            sb.append((char)('a'+random.nextInt(26)));
        }
        return sb.toString();
    }

    public static void main(String argc[]){
        System.out.println("Comparing trad str comparsion alg with kmp...");
        String tar = randomStr();
        int randomStart = random.nextInt(tar.length()-10);
        String pattern = tar.substring(randomStart,randomStart+10);
        System.out.printf("text:%s\npattern:%s\n",tar,pattern);
        System.out.printf("Start point:%d\n",randomStart);
        System.out.println();


        long beforeTradStart = System.currentTimeMillis();
        boolean result = trad(tar,pattern);
        long tradStartend = System.currentTimeMillis();
        System.out.printf("result:%b\ttrad comparsion cost:%d\n",result,tradStartend-beforeTradStart);

        long beforeKMPStart = System.currentTimeMillis();
        boolean KMPresult = KMP(tar,pattern);
        long KMPStartend = System.currentTimeMillis();
        System.out.printf("result:%b\tkmp comparsion cost:%d\n",KMPresult,KMPStartend-beforeKMPStart);

    }

    private static boolean KMP(String tar, String pattern) {
        int next[] = new int[pattern.length()];
        int i=1,j=0;

        while (i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                next[i] = j+1;
                i++;j++;
            }else {
                if(j==0){
                    i++;
                    continue;
                }

                while (pattern.charAt(i) != pattern.charAt(j)
                        && j!=0){
                    j = next[j-1];
                }
                if(pattern.charAt(i) == pattern.charAt(j)){
                    next[i] = j+1;
                    j++;i++;
                }else{
                    i++;
                }
            }
        }

        i=0;
        while (j<pattern.length() &&i<tar.length()){
            if(tar.charAt(i) == pattern.charAt(j)){
                i++;j++;
                continue;
            }else{
                if(j==0){
                    i++;continue;
                }else{
                    j=next[j-1];
                }
            }
        }

        if(j>=pattern.length()){
            return true;
        }
        return false;
    }

    private static boolean trad(String tar, String pattern) {
        int i = 0;
        while (i<tar.length()){
            int temp = i;
            for (int j = 0; j < pattern.length(); j++) {
                if(tar.charAt(temp) == pattern.charAt(j)) {
                    temp++;
                }else{
                    break;
                }
            }
            if((temp-i)==pattern.length()){
                return true;
            }
            i++;
        }
        return false;
    }
}
