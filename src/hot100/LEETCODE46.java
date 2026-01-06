package hot100;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE46 {

//    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        public List<List<Integer>> permute(int[] nums) {

//            输入：nums = [1,2,3]
//            输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

            // 这个跟 39 和 40 有点像，也是递归回溯

            // 核心思路，维护一个path ，一个result
            // 然后每次递归 就把数往里面放，如果path.len 达到 nums长度，就说明选好了一个排列，这时候 path放入 result就行
            // 然后有个问题，每次放数进去，我们要先看这个数是不是被用过了
            // 所以 这里需要引入 一个bool数组标记每个位置的使用情况
            // 然后如果 用过了，当前循环直接跳过

            // 这个默认是 false 也就正好表示 没有访问过
            boolean[] visited = new boolean[nums.length];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            tarvel(nums,res,path,visited);

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

                // 当前数加入 path
                path.add(nums[i]);
                visted[i] = true;

                tarvel(nums,result,path,visted);

                // 回溯
                path.remove(path.size() - 1);
                visted[i] = false;
            }

        }

    public static void main(String[] args) {

            boolean[] visited = new boolean[100];
        System.out.println(visited[0]);

    }



}
