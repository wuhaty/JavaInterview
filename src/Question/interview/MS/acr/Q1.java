package Question.interview.MS.acr;

import java.util.Random;
import java.util.UUID;

public class Q1 {

    static class Obj{
        int  id;
        String str;

        public Obj(int id, String str) {
            this.id = id;
            this.str = str;
        }
    }

    static Random random = new Random();

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        Q1 s = new Q1();
        // int[] res = s.sort(new int[]{3,3,4,9,8,7},10);
//
//        Obj o1 = new Obj(5,"b");
//        Obj o2 = new Obj(0,"d");
//        Obj o3 = new Obj(5,"f");
//        Obj o4 = new Obj(2,"c");
//        Obj o5 = new Obj(3,"e");
//        Obj o6 = new Obj(0,"a");

        Obj[] objs = new Obj[10];

        for (int i = 0; i < 10; i++) {
            objs[i] = new Obj(random.nextInt(11), UUID.randomUUID().toString());
        }

        Obj[] res = s.sort(objs,11);

        for(Obj i:res){
            System.out.print(i.id);
            System.out.print(' ');
            System.out.print(i.str);
            System.out.println();
        }
        System.out.println();
    }



    public Obj[] sort(Obj[] input, int k){
        //require linear time complexity and constant space complexity
        int[] buckets = new int[k+1];

        for (int i = 0; i < input.length; i++) {
            buckets[input[i].id]++;
        }

        int p = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = p; buckets[i] != 0 && j <  input.length; j++) {
                if (input[j].id == i){
                    swap(input,j,p++);
                    buckets[i]--;
                }
            }
        }

        return input;
    }

    private void swap(Obj[] input, int i, int j) {
        Obj t = input[i];
        input[i] = input[j];
        input[j] = t;
    }
}