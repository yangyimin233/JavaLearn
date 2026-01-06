package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组总和 {

//    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//    对于给定的输入，保证和为 target 的不同组合数少于 150 个。


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // 思路是，先排序，然后dfs来
        // 维护一个 path，每次dfs如果减去当前位置，如果target == 0 说明 凑出来一个target

        int[] nums = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 然后是dfs
        dfs(nums,target,result,path,0);

        return result;
    }

    static void dfs(int[]nums, int target, List<List<Integer>> result, List<Integer> path, int index) {

        // 然后是dfs
        if (target == 0) {
            // 说明凑出了 target
            // 注意这里一定要new 一个否则后续会改这里面的
            result.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++) {

            if (nums[i] > target) {
                // 因为这个已经排过序了，所以可以直接剪掉
                break;
            }

            path.add(nums[i]);

            // 然后就是从index 往里面dfs递归了
            // 因为 这个每个数可以重复使用，所以这里下一层还是 从i开始
            dfs(nums, target - nums[i], result, path, i);

            // 然后出来后需要回溯
            path.remove(path.size() - 1);


        }



    }







}
