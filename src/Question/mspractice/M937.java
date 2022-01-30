package Question.mspractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class M937 {
    public static void main(String[] args) {
        M937 m = new M937();
        m.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ");
                int index2 = o2.indexOf(" ");

                String s1 = o1.substring(index1+1);
                String s2 = o2.substring(index2+1);

                boolean isNum1 = isNum(s1);
                boolean isNum2 = isNum(s2);

                if (!isNum1 && !isNum2){
                    String i1 = o1.substring(0,index1+1);
                    String i2 = o2.substring(0,index2+1);

                    int initialCompare = s1.compareTo(s2);
                    return initialCompare == 0? i1.compareTo(i2):initialCompare;
                }else {
                    return isNum1? (isNum2?0:1):-1;
                }
            }
        });

        return logs;
    }

    private boolean isNum(String s){
        return Character.isDigit(s.charAt(0));
    }
}
