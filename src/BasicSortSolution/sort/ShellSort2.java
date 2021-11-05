package BasicSortSolution.sort;

import Func.sort;

public class ShellSort2 implements sort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;

        for (int gap = n/2; gap >0  ; gap/=2) { //group by gap
            for (int i = gap; i < n; i+=gap) {  //start point
                for (int j = i; j >0 ; j-= gap) {
                    if (data[j] < data[j-gap]){
                        int temp = data[j];
                        data[j] = data[j-gap];
                        data[j-gap] = temp;
                    }else {
                        break;
                    }
                }
            }
        }

        return data;
    }
}
