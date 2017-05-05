package Question.leetcode;

/**
 * Created by gump on 2017/5/2.
 */
public class Q75 {
    public static void main(String argc[]){
        Q75 q = new Q75();
        int test[]= {0,1,0,2,0};
        q.sortColors(test);
        System.out.print(test);
    }

    public void sortColors(int[] nums) {
        int index0=-1,index1=-1,index2=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0 ){
                nums[++index2] = 2;
                nums[++index1] = 1;
                nums[++index0] = 0;
            }else if(nums[i]==1 ){
                nums[++index2] = 2;
                nums[++index1] = 1;
            }else if(nums[i]==2 ){
                nums[++index2] = 2;
            }
        }
    }
}
