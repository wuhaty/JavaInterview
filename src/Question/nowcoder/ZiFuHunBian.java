package Question.nowcoder;

/**
 *
 * A、B和C。如果C包含且仅包含来自A和B的所有字符，而且在C中属于A的字符之间保持原来在A中的顺序，
 * 属于B的字符之间保持原来在B中的顺序，那么称C是A和B的混编。实现一个函数，判断C是否是A和B的混编。
 * 给定三个字符串A,B和C，及他们的长度。请返回一个bool值，代表C是否是A和B的混编。保证三个串的长度均小于等于100。
 * 测试样例：
 *      "ABC",3,"12C",3,"A12BCC",6
 *      返回：true
 */
public class ZiFuHunBian {
    public static void main(String argc[]){
        System.out.print(chkMixture("ABC",3,"AABC",4,"AAABCBC",7));
    }

    public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if(n+m!=v){
            return false;
        }

        boolean result[][] = new boolean[n+1][m+1];
        result[0][0] = true;
        for (int i = 0; i < n; i++) {
            if(A.charAt(i) == C.charAt(i)){
                result[i+1][0] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if(B.charAt(i) == C.charAt(i)){
                result[0][i+1] = true;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if( (A.charAt(i-1)==C.charAt(i+j-1) && result[i-1][j])
                        || (B.charAt(j-1)==C.charAt(i+j-1) && result[i][j-1])){
                    result[i][j] = true;
                }
            }
        }
        return result[n][m];
    }
}
