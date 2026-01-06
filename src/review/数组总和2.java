package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组总和2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 跟39的区别在于 这个 不允许数重复使用，并且，还需要剔除本质一样的选取数组
        // 这里直接在39上面改

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

            // 然后剔除重复的，其实跟三数之和那里是一样的
            // 因为排过序了，如果当前index 的数和他前面的一样
            // 那这轮循环没必要继续，因为这轮的合法path，一定被前面的也选过了
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }


            if (nums[i] > target) {
                // 因为这个已经排过序了，所以可以直接剪掉
                break;
            }

            path.add(nums[i]);

            // 然后就是从index 往里面dfs递归了
            dfs(nums, target - nums[i], result, path, i+1);

            // 然后出来后需要回溯
            path.remove(path.size() - 1);


        }



    }



}
