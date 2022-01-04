package Question.sword;

public class O5 {
    public String replaceSpace(String s) {
        if (s==null) return null;
        char[] cs = s.toCharArray();
        char[] res = new char[cs.length * 3];
        int count = 0;
        for (int i = 0,j=0; i < cs.length; i++) {
            if (cs[i] == ' '){
                res[j] = '%';
                res[j+1] = '2';
                res[j+2] = '0';
                count+=3;
                j+=2;
            }else {
                res[j] = cs[i];
                count++;
                j++;
            }
        }
        return new String(res,0,count);
    }
}
