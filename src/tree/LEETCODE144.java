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

            // 迭代法可以按照我这么记，比较清楚

            List<Integer> res = new ArrayList<>();

            // 这个stack是用来记录处理节点的
            Deque<TreeNode> stack = new LinkedList<>();

//            // 最外层循环: 如果此时没有右孩子了，待处理栈也为空了
//            while(root!=null||stack.isEmpty()==false){
//                // 里层循环：一直往下找直到找到没有左孩子的节点，并且每次都将该节点入栈(因为该节点还有右孩子分支需要处理)
//                while (root!=null){
//                    // 存储root节点val
//                    res.add(root.val);
//                    // 当前节点入栈
//                    stack.push(root);
//                    // 指向root的左孩子，继续往下找
//                    root = root.left;
//                }
//                // 里层循环退出说明当前一定指向了null，这时候就需要回到上一个节点，去上一个节点的右孩子，然后继续进入这个右孩子的左分支
//                root = stack.pop();
//                root = root.right;
//
//            }

//            return res;




//            // 上面演示的是前序遍历，这里再演示中序和后续遍历
//            // 总体框架是一样的
//            // 中序遍历和前序遍历的迭代法都只需要简单改一下 存val的语句位置就行
//            // 中序是 左 中 右 ，所以一开始还是使劲往左孩子里面钻，钻到最左分支结束的时候
//            // 弹回到上一个节点，记录最左孩子，然后右一下，重复
//            while(root!=null || stack.isEmpty()==false){
//
//                while(root!= null){
//                    // 往左孩子里面钻
//                    stack.push(root);
//                    root = root.left;
//                }
//                // 出来了，说明栈最顶的是最左的，弹出来
//                root = stack.pop();
//                res.add(root.val);
//                root = root.right;
//
//            }

//            return res;


            // 然后是后续遍历，想想这里能不能直接像那个递归法一样，简单改一下存val的语句位置就行了？
            // 不能，这个会漏掉最左的节点
            // 因为最左的节点出栈后，没有被add语句操作，就指向了改节点的右孩子，而且该节点也不一定有右孩子

            // 这里我推荐的方法是 后序遍历 跟 前序遍历 可以互相转换
            // 你前序 是 根左右，后续是 左右根， 所以你把前序那里到过来 ，同时每次先往右节点使劲钻 就行了

            while(root!=null || !stack.isEmpty()){

                while(root!= null){
                    res.add(root.val);
                    // 往右孩子里面钻
                    stack.push(root);
                    root = root.right;
                }
                // 出来了，说明栈最顶的是最右的，弹出来，然后变成左一位
                root = stack.pop();
                root = root.left;
            }

            // 上面出来的结果就是 根 右 左 的顺序，这里再倒序一下就是后续遍历了
            List<Integer> trres = new ArrayList<>();
            while(!res.isEmpty()){
                // 将res的最后一个加入到trres中
                trres.add(res.get(res.size()-1));
                // 再移除
                res.remove(res.size()-1);
            }
            return trres;

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
