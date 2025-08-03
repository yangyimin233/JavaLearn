package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEETCODE15 {

    // 三数之和

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        // 思路是
        // 先对数组进行排序
        // 然后固定一个i从0开始，之后左右指针依次汇聚

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            int left =  i+1;
            int right = nums.length-1;

            // 然后就是什么情况会出现重复？
            // 当 遍历的nums i [] 与之前的一样时候，一定会重复

            // 这里说明 i已经到末尾了
            if(left<=right){
                break;
            }

            if(i!=0 && nums[i]==nums[i-1]){
                // 与之前的i一样，说明出现了重复
                continue;
            }

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    // 如果相等就加入
                    List<Integer> templist = new ArrayList<>();
                    templist.add(nums[left]);
                    templist.add(nums[right]);
                    templist.add(nums[i]);
                    result.add(templist);
                    // 思考，排序之后，如果这里找到了一组结果后，还需要继续找吗？
                    // -4 1 2 2 3  //i在第一个 ，这里说明是还要继续找的，因为还可能组合出不同的
                    // 然后就是怎么移动指针？左右一起向中间靠拢会不会有遗漏？
                    // 不会，因为只调整一边指针，下一次的sum 一定会大于等于，或者小于等于
                    // 等于的情况 一定是左右指针与上一次缩短前的位置的值是一致的
                    // 所以这种情况本来也不要

                    left++;
                    right--;

                    // 然后这里还需要考虑重复的问题
                    // 假设 左指针位置跟 上一次左指针位置 的值 一致
                    while (left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while (left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }

                // 然后是不等于的情况，这里移动指针就需要详细的考虑了
                // 说明和小了，需要左指针右移
                if(sum<0){
                    left++;
                }
                if(sum>0){
                    right--;
                }


            }




        }


        return result;








    }



}
