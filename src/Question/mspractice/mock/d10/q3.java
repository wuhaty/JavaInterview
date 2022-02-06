package Question.mspractice.mock.d10;

import java.util.LinkedList;
import java.util.List;

public class q3 {
    public static void main(String[] args) {
        q3 q = new q3();
        q.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();

        int i = 0,j=0;
        int n = words.length;
        StringBuilder sb = new StringBuilder();

        while (true){
            i = j;
            int wordLenCount = 0;
            int spaceCount = 0;
            sb = new StringBuilder();
            while (j < n && (wordLenCount+spaceCount+words[j].length())<=maxWidth){
                wordLenCount+=words[j++].length();
                spaceCount++;
            }

            spaceCount = maxWidth - wordLenCount;

            if (j == n){
                //last row;
                sb.append(join(words,i,j," "));
                String trailingSpace = generateSpace(maxWidth-sb.length());
                sb.append(trailingSpace);
                res.add(sb.toString());
                return res;
            }

            int wordCount = j-i;
            if (j-i==1){
                //only 1 word
                sb.append(words[i]);
                String trailingSpace = generateSpace(spaceCount);
                sb.append(trailingSpace);
                res.add(sb.toString());
                continue;
            }

            int avgSpaces = spaceCount/(wordCount-1);
            int extraSpaces = spaceCount%(wordCount-1);

            sb.append(join(words,i,i+extraSpaces+1,generateSpace(avgSpaces+1)));
            sb.append(generateSpace(avgSpaces));
            sb.append(join(words,i+extraSpaces+1,j,generateSpace(avgSpaces)));
            res.add(sb.toString());
        }
    }

    private String join(String[] words,int left, int right,String splitter){
        StringBuilder sb = new StringBuilder();
        sb.append(words[left]);

        for (int i = left+1; i < right; i++) {
            sb.append(splitter);
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private String generateSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
