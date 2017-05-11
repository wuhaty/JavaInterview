package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q165 {
    public static void main(String argc[]) {
        Q165 q = new Q165();
        System.out.println(q.compareVersion("1", "1.1"));
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
}
