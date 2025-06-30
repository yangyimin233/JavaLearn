package simple100;

//import org.junit.Test;

public class leetcode1 {

    //

    public static void main(String[] args) {
        leetcode1 lc = new leetcode1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = lc.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }


    public int[] twoSum(int[] nums, int target) {

        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // 如果上面那个循环没找到就return的是null的
        return result;
    }

}
