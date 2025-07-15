package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE513 {

//    给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
//    假设二叉树中至少有一个节点。

    public int findBottomLeftValue(TreeNode root) {

        // 这种思路一看就是层序遍历

        // 什么叫做 最底层 的最左边的节点？
        // 还是直接设计分层吧，先写最简单的

        int res = 0;
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            // 实际上不会，因为他说至少有一个节点
            return 0;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {

            int len = queue.size();

            boolean find = false;
            while (len > 0) {

                TreeNode node = queue.poll();
                if (!find && node.right==null && node.left==null) {
                    // 更新res
                    res = node.val;
                    // 当前层已找到叶子节点，只需要第一个
                    find = true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len -- ;
            }

        }

        return res;




    }



}
