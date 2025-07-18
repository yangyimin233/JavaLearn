package tree;

public class LEETCODE654 {


//    给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
//    创建一个根节点，其值为 nums 中的最大值。
//    递归地在最大值 左边 的 子数组前缀上 构建左子树。
//    递归地在最大值 右边 的 子数组后缀上 构建右子树。
//    返回 nums 构建的 最大二叉树 。


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // 终止条件：空区间
        if (left >= right) {
            return null;
        }

        // 找最大值位置
        int maxPos = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }

        // 构造当前节点
        TreeNode root = new TreeNode(nums[maxPos]);

        // 构建左子树 [left, maxPos)
        root.left = buildTree(nums, left, maxPos);

        // 构建右子树 [maxPos + 1, right)
        root.right = buildTree(nums, maxPos + 1, right);

        return root;
    }



}
