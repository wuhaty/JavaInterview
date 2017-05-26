package Question.classified.Permutation;

/**
 * Created by gump on 2017/5/26.
 */


class PrintToMaxDigits{

    public static void main(String argc[]){
        print(3);
    }

    public static void print(int n){
        if (n<=0) return;
        char input[] = new char[n];

        for (int i = 0; i < 10; i++) {
            input[0] = (char)(i + '0') ;
            printToMax(input,n,0);
        }
    }

    private static void printToMax(char[] input, int n, int begin) {
        if (begin == n-1){
            PrintNumber(input);
            return;
        }

        for (int i = 0; i < 10; i++) {
            input[begin+1] = (char)(i + '0') ;
            printToMax(input,n,begin+1);
        }
    }

    private static void PrintNumber(char[] input) {
        boolean skip =true;
        for (int i = 0; i < input.length; i++) {
            if ((input[i]!='0' && skip) || i==input.length-1){
                skip = false;
            }

            if (!skip){
                System.out.print(input[i]);
            }
        }
        System.out.println();
    }
}
