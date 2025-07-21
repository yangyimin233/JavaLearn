package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LEETCODE617 {



//    想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
//    你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
//
//    返回合并后的二叉树。
//
//    注意: 合并过程必须从两个树的根节点开始。


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 思路上来说的话，最直观的，还是采用层序遍历两个二叉树，依次往下面合并

//        Deque<TreeNode> queue1 = new LinkedList<>();
//        Deque<TreeNode> queue2 = new LinkedList<>();
//
//        // 两个队列用来存储两个二叉树的节点
//        if (root1 == null) return root2;
//        if (root2 == null) return root1;
//        // 还需要一个
//
//        queue1.offer(root1);
//        queue2.offer(root2);
//
//        // 只要有一个队列不为空，就一直循环
//        while (!queue1.isEmpty() && !queue2.isEmpty()) {
//            TreeNode node1 = queue1.poll();
//            TreeNode node2 = queue2.poll();
//
//            // 新建一个节点，好理解点
//            TreeNode newNode = new TreeNode(0);
//            // 判断节点是否空，如果空就赋值为0
//            int val1 = node1 == null ? 0 : node1.val;
//            int val2 = node2 == null ? 0 : node2.val;
//
//            // 合并节点
//            newNode.val = val1 + val2;
//
//            // 然后是左右孩子
//
//
//
//
//        }


        // 呃好像不是很好搞，主要是这个新节点怎么指向左右孩子，所以这里还是采用递归的方法

        return mergeTrees2(root1, root2);






    }



    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {

        // 确定先是递归返回的条件
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 合并两个节点
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        // 然后递归合并左右孩子
        newNode.left = mergeTrees2(root1.left, root2.left);
        newNode.right = mergeTrees2(root1.right, root2.right);

        // 返回新节点
        return  newNode;




    }



}
