package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LEETCODE112 {

//    给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//    说明：叶子节点是指没有子节点的节点


    // 112是求最大深度，这个好搞，我已经放到层序遍历102下面了，现在是111求最小深度
    // 当然还是层序遍历的模板
    // 你想，这里层序遍历是一层一层从左到右遍历的，如果遍历到某个节点，他没有左右孩子，那他一定是距离根节点最近的 叶子节点，你想是不是这个道理


    public int minDepth(TreeNode root) {

        // 只要有根节点，那一开始就是第一层
        int res = 1;

        // 队列
        Deque<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        if (root == null) return 0;
        queue.offer(root);

        while(!queue.isEmpty()){

            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                if (temp.left == null && temp.right == null) {
                    // 说明当前节点没有左右孩子了
                    // 这里就可以直接return了
                    return res;
                }
                len--;
            }
            res++;
        }



        return res;
    }

}
