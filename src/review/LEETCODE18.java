package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEETCODE18 {

    //    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。


    // 还是先基于 三数之和 来做
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        // 思路是
        // 先对数组进行排序
        // 然后固定一个i从0开始，之后左右指针依次汇聚

        Arrays.sort(nums);

        // 然后外面再给他套一层循环 来个j
        for (int j = 0; j < nums.length - 3; j++) {

            // 然后是j的去重部分，这里实际上是一样的

            if(j!=0 && nums[j]==nums[j-1]){
                // 与之前的i一样，说明出现了重复
                continue;
            }




            for(int i = j+1; i<nums.length - 2;i++){
                int left =  i+1;
                int right = nums.length-1;
                // 然后就是什么情况会出现重复？
                // 当 遍历的nums i [] 与之前的一样时候，一定会重复

                if(i!=j+1 && nums[i]==nums[i-1]){
                    // 与之前的i一样，说明出现了重复
                    continue;
                }
                while(left<right){
                    long sum = (long)nums[j] + (long)nums[i] + (long)nums[left] + (long)nums[right];
                    if(sum==target){
                        // 如果相等就加入
                        List<Integer> templist = new ArrayList<>();
                        templist.add(nums[left]);
                        templist.add(nums[right]);
                        templist.add(nums[i]);
                        templist.add(nums[j]);
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
                    if(sum<target){
                        left++;
                    }
                    if(sum>target){
                        right--;
                    }
                }
            }



        }



        return result;








    }


}
