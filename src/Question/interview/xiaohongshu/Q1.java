package Question.interview.xiaohongshu;

public class Q1 {

        public static int indexOf(String str, String target) {
            if(target == null || target.isEmpty()) return -1;

            int i = 0, j = 0;

            while(i < str.length()){
                int k = i;
                while(j< target.length() && k < str.length()) {
                    char s = str.charAt(k);
                    char t = target.charAt(j);
                    if (s!=t) break;
                    k++;
                    j++;
                }

                if(j == target.length()) return i;
                j = 0;
                i++;
            }
            return -1;
        }

        public static void main(String args[]){
            System.out.println(indexOf("bcbcbce","bcbce"));
            System.out.println(indexOf("abc",null));
            System.out.println(indexOf("abc","b"));
            System.out.println(indexOf("abc","bc"));
            System.out.println(indexOf("abc","d"));
            System.out.println(indexOf("abc","abcd"));
            System.out.println(indexOf("abc","ab"));
        }

}
