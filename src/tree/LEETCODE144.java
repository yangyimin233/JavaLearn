package tree;


import javax.swing.*;
import java.util.*;

public class LEETCODE144 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public List<Integer> preorderTraversal(TreeNode root) {

            // 先用那个递归做一遍，之后那个迭代法也要写一遍
//            List<Integer> res = new ArrayList<>();
//
//            inorderTraversal(root, res);
//
//            return res;

            // 然后我们再用迭代做一遍
            // 迭代的核心思路得利用栈的思想，比如这里是先根节点遍历
            // 每个节点都是根 左 右 而 左右这些也可能还有左右孩子

            List<Integer> res = new ArrayList<>();

            // 这个stack是用来记录处理节点的
            Deque<TreeNode> stack = new LinkedList<>();

            // 最外层循环: 如果此时没有右孩子了，待处理栈也为空了
            while(root!=null||stack.isEmpty()==false){
                // 里层循环：一直往下找直到找到没有左孩子的节点，并且每次都将该节点入栈(因为该节点还有右孩子分支需要处理)
                while (root!=null){
                    // 存储root节点val
                    res.add(root.val);
                    // 当前节点入栈
                    stack.push(root);
                    // 指向root的左孩子，继续往下找
                    root = root.left;
                }

            }



            return res;

        }

        public static void inorderTraversal(TreeNode root, List<Integer> res) {
            // 这里是递归方法
            // 写递归要先确定返回条件，比如这里每次进入这个遍历递归，如果节点指向为null，则return，否则 再将其 左孩子 传入 递归函数

            if (root == null) {
                // 本次递归退出条件
                return;
            }
            // 这里是前序遍历，所以存入节点val的的语句要写在哪里？
            // 肯定不能写在 if 之前，不然你这个root为空的时候就直接空指针异常了

            // 如果有左孩子，则左孩子作为根节点再走一次递归流程，一直走到第一次所有得左孩子都遍历了，此时会遇到那个递归return语句，然后这时候就回到上次传入左孩子得语句之后，开始遍历右孩子
            res.add(root.val);
            inorderTraversal(root.left,res);
            inorderTraversal(root.right,res);
        }



}
