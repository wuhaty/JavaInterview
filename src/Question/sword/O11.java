package Question.sword;

public class O11 {
    public int minArray(int[] numbers) {
        int l = 0,r = numbers.length-1;

        while (l<r) {
            int mid = l + (r-l)/2;

            if (numbers[r] > numbers[mid]) {
                //right ascending
                r = mid;
            }else if (numbers[r] < numbers[mid]){
                //left ascending
                l = mid+1;
            }else {
                r--;
            }
        }

        return numbers[l];
    }
}
