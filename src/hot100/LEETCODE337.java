package hot100;

public class LEETCODE337 {


    // 传奇偷家王

    public int rob(TreeNode root) {
        // 那肯定还是动规来做
        return travel(root);

    }

    // 过是过了，就是超时间限制了

    static int travel(TreeNode node) {
        // 这个用来标记 当前节点往下走 最大偷取金额

        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null) {
            // 叶子节点
            return node.val;
        } else {
            // 非叶子节点
            // 两种情况
            // 不偷 , 就直接是这个节点往下 左右孩子的 最大值
            // 想想看，这里回不会爆空指针问题？
            // 不会，因为node能走到这，那么node一定非空
            // node的孩子存在空怎么办？
            // 没关系，我们最前面有 null进去，直接return 0 了
            int not = travel(node.left) + travel(node.right);

            // 偷
            // 只能是从该节点的孩子的孩子开始考虑
            // 首先这里进来了说明至少有一个孩子
            int yesleft = 0;
            int yesright = 0;
            if (node.left != null) {
                // 左孩子非空
                yesleft = travel(node.left.left)+travel(node.left.right);
            }
            if (node.right != null) {
                // 右孩子非空
                yesright = travel(node.right.left)+travel(node.right.right);
            }
            int yes = node.val + yesleft + yesright;

            return Math.max(yes, not);

        }


    }

}
