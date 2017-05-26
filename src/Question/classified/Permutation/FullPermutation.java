package Question.classified.Permutation;

/**
 * Created by gump on 2017/5/26.
 */
public class FullPermutation {

    public static void main(String argc[]){
        Permutation("abc");
    }

    private static void Permutation(String str) {
        if (str == null || str.isEmpty()) return;
        char input[] = str.toCharArray();
        Permutation(input,0);
    }

    private static void Permutation(char[] str, int strBegin) {
        if (strBegin >= str.length){
            System.out.println(str);
        }else{
            for (int i = strBegin; i < str.length; i++) {
                char temp = str[strBegin];
                str[strBegin] = str[i];
                str[i] = temp;

                Permutation(str,strBegin +1);

                temp = str[i];
                str[i] = str[strBegin];
                str[strBegin] = temp;
            }
        }
    }

}
