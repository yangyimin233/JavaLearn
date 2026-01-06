package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEETCODE47 {

    //    给定一个可能含重复数字的数组 nums ，返回其 所有可能的全排列 。
    // 跟46的区别在于需要去重

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 这个跟 39 和 40 有点像，也是递归回溯

        // 核心思路，维护一个path ，一个result
        // 然后每次递归 就把数往里面放，如果path.len 达到 nums长度，就说明选好了一个排列，这时候 path放入 result就行
        // 然后有个问题，每次放数进去，我们要先看这个数是不是被用过了
        // 所以 这里需要引入 一个bool数组标记每个位置的使用情况
        // 然后如果 用过了，当前循环直接跳过

        // 这个默认是 false 也就正好表示 没有访问过

        int[] numssorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numssorted);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        tarvel(numssorted,res,path,visited);

        return res;


    }

    static void tarvel(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] visted) {

        if (path.size() == nums.length) {
            // 到达长度，获得一条已经选好的组合
            result.add(new ArrayList<>(path));
        }

        // 然后没到长度，就数组一个一个往里面扔
        for (int i = 0; i < nums.length; i++) {
            if (visted[i]) {
                // 当前位置已经被使用了
                continue;
            }

            // 这里还需要 去重，因为输入nums 已经排过序了
            // 注意 当前数跟前面一样
            // 我们并且前面没有访问过，这时候跳过
            // 想想为什么是 没有访问过

            if (i>0 && nums[i] == nums[i-1] && !visted[i-1]) {
                continue;
            }

            // 当前数加入 path
            path.add(nums[i]);
            visted[i] = true;

            tarvel(nums,result,path,visted);

            // 回溯
            path.remove(path.size() - 1);
            visted[i] = false;
        }

    }



}
