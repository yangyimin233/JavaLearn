package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEETCODE39 {

//    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//    对于给定的输入，保证和为 target 的不同组合数少于 150 个。

//    输入：candidates = [2,3,6,7], target = 7
//    输出：[[2,2,3],[7]]


    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        // 核心思路
        // 排序 + 回溯
        // dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res)

        // 从排序后的 candidates 数组中，从索引 start 开始，尝试将每个数字加入当前路径 path 中，并递归调用 dfs 函数，直到路径和等于 target 或超过 target
        List<List<Integer>> res = new java.util.ArrayList<>();
        List<Integer> path = new java.util.ArrayList<>();

        // 先对 candidates 进行排序
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, res);

        return res;

    }


    static void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {

        // 递归终止条件，传入的target=0，说明找到了一个符合条件的组合
        if (target == 0) {
            // 将当前路径加入结果集
            // 注意要 new 一个新的 list 出来，否则后续 path 变化会影响结果集
            res.add(new ArrayList<>(path));
            return;
        }


        // 然后从 i = start开始，dfs
        for (int i = start; i < candidates.length; i++) {

            // 这里还必须得剪枝，不剪枝就会栈溢出
            int x = candidates[i];
            if (x > target) break; // 剪枝
            // 为啥是在这里add？ 因为你是先选这个数，然后再去递归
            path.add(x);
            // 注意这里允许数重复使用，所以第深层的dfs start还是i
            dfs(candidates, target - candidates[i], i , path, res);
            // 然后在这里回溯
            path.remove(path.size() - 1);

        }

        // 总结 dfs (候选数组，目标值，起始索引，当前路径，结果集)
        // dfs里面:
        // 1. 递归终止条件：target==0，说明找到了一个符合条件的组合，将当前路径加入结果集

        // 2. 开始从起始索引 start 遍历候选数组 candidates
        // for (int i = start; i < candidates.length; i++)
        // for里面
        // 1. 剪枝：如果当前数字大于 target，直接跳出循环
        // 2. 选择当前数字：将其加入当前路径 path
        // 3. 递归调用 dfs，更新目标值为 target - candidates[i]，起始索引仍为 i（允许重复使用当前数字）
        // 4. 回溯：将当前数字从路径中移除，尝试下一个数字


        // 拓展，如果不允许重复使用
        // 改的方法 有点类似那个三数之和
        // 剪枝完之后还要判断，如果i不是第一个数 且 candidates[i] == candidates[i-1] 就直接 continue
        // 然后 内层dfs那里 入口变为 i+1


    }

}
