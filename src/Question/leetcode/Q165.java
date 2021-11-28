package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q165 {
    public static void main(String argc[]) {
        Q165 q = new Q165();
        System.out.println(q.compareVersion2021("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int temp1 = i>=v1.length?0:Integer.parseInt(v1[i]);
            int temp2 = i>=v2.length?0:Integer.parseInt(v2[i]);
            if (temp1 > temp2) return 1;
            else if (temp1 < temp2) return -1;
        }
        return 0;
    }


    public int compareVersion2021(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");

        int n = Math.max(s1.length,s2.length);

        for (int i = 0; i < n; i++) {
            int v1 = 0;
            int v2 = 0;
            if (i<s1.length) v1 = Integer.parseInt(s1[i]);
            if (i<s2.length) v2 = Integer.parseInt(s2[i]);

            if (v1<v2) {
                return -1;
            }else if(v1>v2){
                return 1;
            }
        }
        return 0;
    }
}
