package hot100;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;

public class LEETCODE437 {

    public int pathSum(TreeNode root, int targetSum) {

//        // 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树中节点值之和等于 targetSum 的 路径 的数目。
//        // 路径 不需要从根节点开始，也不需要在叶子节点结束，但路径方向必须是向下的（只能从父节点到子节点）。
//
//        // 我按我想的来做
//        // 类似 返回二叉树 所有路径那样，我们返回一个list<list<Integer>> res ，然后在这里面求和为 targetSum 的路径数目
//
//        List<List<Integer>> paths = new ArrayList<>();
//        travelGetPath(root,new ArrayList<Integer>(),paths);
//
//        int count = 0;
//
//        // 然后现在我们有了所有路径
//        for (int i = 0; i < paths.size(); i++) {
//            List<Integer> path = paths.get(i);
//            // 一条一条来计算这个路径中 有多少个子路径 和为 targetSum
//            for (int start = 0; start < path.size(); start++) {
//                int sum = 0;
//                for (int end = start; end < path.size(); end++) {
//                    sum += path.get(end);
//                    if (sum == targetSum) {
//                        count++;
//                    }
//                }
//            }
//
//
//        }
//
//        return count;

        // 哦哦这样有一个致命的bug，就是会数重复
        // 比如
        // 第一层 1
        // 第二层 也是 1
        // 第三层 为 2，3
        // 根节点到叶子节点一共 两条路径 1-1-2 和 1-1-3
        // 假设 targetSum = 2
        // 公用的 1-1 会被算两次

        return travelGetPathCount(root, targetSum, new ArrayList<Integer>());




    }


    static void travelGetPath(TreeNode root, List<Integer> path, List<List<Integer>> res) {

        // 跟之前一样，用前序遍历的方式，遍历二叉树，记录路径
        // 需要记得回溯
        if (root == null) {
            return;
        }

        // 记录加入当前节点前的路径长度
        int len = path.size();
        path.add(root.val);

        if (root.left == null && root.right == null) {
            // 到叶子节点了
            // path 加到res中
//            res.add(path);
            // 上面那样写是错误的，直接放进去 是引用，后面改了 path 后，res 中的 path 也会变
            // 一定要记得 new 一个新的list
            res.add(new ArrayList<>(path));

        }

        // 然后依次遍历左右子树
        if (root.left != null) {
            travelGetPath(root.left, path, res);
        }
        if (root.right != null) {
            travelGetPath(root.right, path, res);
        }

        // 走到这 就需要回溯了
        while (path.size() != len) {
            // 回溯到加入当前节点前的状态
            // 思考 这里会回溯几次？ 答案是1次
            // 因为记录len后，只加入了一个节点
            // 不要管后面的递归调用，因为递归调用结束后，path也会走这里，回到了加入当前节点后的状态
            path.remove(path.size() - 1);
        }




    }



    // 所以推荐的做法是 边 记录路径 边 计算和
    static int travelGetPathCount(TreeNode root, int targetSum, List<Integer> path) {


        if (root == null) {
            return 0;
        }

        // 不是叶子节点，开始从path中向前处理，计算有多少条路径和为 targetSum
        int count = 0;
        int len = path.size();
        path.add(root.val);
        Long sum = 0L;
        // 注意这里是从该节点往 前计算和
        for (int i = len; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                count++;
            }
        }
        // 然后递归处理左右子树
        if (root.left != null) {
            count += travelGetPathCount(root.left, targetSum, path);
        }
        if (root.right != null) {
            count += travelGetPathCount(root.right, targetSum, path);
        }

        // 回溯
        while (path.size() != len) {
            path.remove(path.size() - 1);
        }

        return count;




    }




}
