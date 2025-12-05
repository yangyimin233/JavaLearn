package hot100;

public class LEETCODE124 {

//    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//    路径和 是路径中各节点值的总和。
//
//    给你一个二叉树的根节点 root ，返回其 最大路径和 。



    public int maxPathSum(TreeNode root) {
        int sum = 0;

        // 他这里最大路径 不是根节点到 叶子节点的，而是 可以往上走的，贯穿的那种也行

        // 我们先来个简单的 根节点到叶子节点的
        // 很明显这中得递归



        return sum;
    }


    static int travelPath(TreeNode node){





        // 非叶子节点
        if (node.left != null && node.right != null) {
            // 返回左右里面大的那个
            return node.val + Math.max(travelPath(node.left), travelPath(node.right));
        }
        else if (node.right != null) {
            return node.val + travelPath(node.right);
        }
        else if (node.left != null) {
            return node.val + travelPath(node.left);
        }



        // 说明是叶子节点
        return node.val;




    }

}
