package Question.interview.indeed;

import java.util.Scanner;

/**
 * Created by gump on 2017/5/26.
 */
public class Practice {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        char s[] = new char[N];
        for(int i=0;i<N;i++) {
            s[i] = (char)('A'+i);
        }

        insertSort(s,N);
        System.out.printf("! %s\n",new String(s));
        System.out.flush();
    }

    private static void insertSort(char[] s, int n) {
        for (int i = 1; i < n; i++) {
            int swapPos = BinarySearch(s,0,i-1,s[i]);
            char temp = s[i];
            int j = i;
            while (j>swapPos){
                s[j] = s[j-1];
                j--;
            }
            s[swapPos] = temp;
        }
    }

    private static int BinarySearch(char[] s, int l, int h,char tar) {
        while (l<=h){
            int mid = (l+h)/2;
            System.out.printf("? %c %c\n",s[mid],tar);
            System.out.flush();
            Scanner sc = new Scanner(System.in);

            if (sc.next().equals(">")){
                h = mid -1;
            }else {
                l = mid +1;
            }
        }
        return l;
    }
}
