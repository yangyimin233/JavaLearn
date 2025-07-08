package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE222 {

//    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
//    完全二叉树 的定义如下：
//    在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。


    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        System.out.println(countNodes(root));



    }

    public int countNodes(TreeNode root) {

        // 思路，随便想一种遍历方式，遍历count++就行
        // 先试试嘛
//        int result = 0;
//        // 比如这里就再来谢谢这个先根遍历写着玩吧
//        // 来个栈
//        Deque<TreeNode> stack = new LinkedList<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root!=null) {
//                result ++;
//                stack.push(root);
//                root = root.left;
//            }
//            // 出循环了，说明上面已经到最左分之了，弹一个出来，右偏一个
//            root = stack.pop();
//            root = root.right;
//        }
//        return  result;


        // 这样再来个层序遍历做一下吧
        int result = 0;




        return result;


    }


}
