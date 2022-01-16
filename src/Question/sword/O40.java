package Question.sword;

public class O40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        partition(arr,0,arr.length-1,k-1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    private void partition(int[] arr, int l, int r,int k) {
        if (l>r) return;

        int i = l;
        int j = r;
        int t = arr[l];
        while (i<j){
            while (i<j && arr[j]>=arr[l]) j--;
            while (i<j && arr[i]<=arr[l]) i++;

            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        arr[i] = arr[l];
        arr[l] = t;

        if (i==k){
            return;
        }else if (i<k){
            partition(arr,i+1,r,k);
        }else {
            partition(arr,l,i-1,k);
        }

        return;
    }
}
