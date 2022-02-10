package BasicSortSolution.sort;

import java.util.Random;

import Func.sort;


public class MainTestForSort {
    public static final int SCALE = 10;
    private static int[] genIntData() {
        int data[] = new int[SCALE];
        for (int i = 0; i < data.length; i++) {
            Random random = new Random();
            data[i] = random.nextInt(SCALE);
        }
        return data;
    }

    private static void printResult(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args){
        int data[] = genIntData();
        printResult(data);
        sort sortSolution = new HeapSortOPT();
        data = sortSolution.sort(data);
        printResult(data);
    }
}
