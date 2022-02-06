package Question.mspractice;

public class M165 {

    public static void main(String[] args) {
        M165 m = new M165();
        m.compareVersion("1.0","1.0.0");
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i =0,j=0;

        while (i<v1.length || j< v2.length){
            int p = 0, q = 0;
            int i1 = 0 , i2 = 0;
            if (i < v1.length){
                while (p < v1[i].length() && v1[i].charAt(p) == '0') p++;
                i1 = p < v1[i].length() ? Integer.parseInt(v1[i].substring(p)):0;
            }

            if (j < v2.length){
                while (q < v2[j].length() && v2[j].charAt(q) == '0') q++;
                i2 = q < v2[j].length()? Integer.parseInt(v2[j].substring(q)):0;
            }

            if (i1>i2){
                return 1;
            }else if (i1<i2){
                return -1;
            }else {
                i++;j++;
            }
        }

        return 0;
    }
}
