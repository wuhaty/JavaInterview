package Question.mspractice.mock.d12;

public class q3 {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean isNumAppeared = false;
        boolean isDotAppeared = false;
        boolean isEAppeared = false;
        boolean isSignAppeared = false;

        int i = 0;
        if (cs[0] == '+' || cs[0] == '-') {
            i++;
            isSignAppeared = true;
        }


        while (i<n){
            char ch = cs[i];
            if (Character.isLetter(ch)){
                if (!isEAppeared && isNumAppeared && Character.toLowerCase(ch) == 'e'){
                    isEAppeared = true;
                    //skip e
                    i++;
                    boolean isEFollowedNum = false;
                    if (i<n && (cs[i] == '+' || cs[i]=='-')){
                        i++;
                    }

                    while (i< n && (Character.isDigit(cs[i]))){
                        isEFollowedNum = true;
                        i++;
                    }

                    if (i!=n || !isEFollowedNum) return false;
                }else {
                    return false;
                }
            }else if (ch == '.'){
                if (isDotAppeared) return false;
                isDotAppeared = true;
                i++;
            }else if (ch == '+' || ch == '-'){
                if (isSignAppeared || i != 0) return false;
                isSignAppeared = true;
                i++;
            }else if (Character.isDigit(ch)){
                isNumAppeared = true;
                i++;
            }
        }
        return isNumAppeared;
    }
}
