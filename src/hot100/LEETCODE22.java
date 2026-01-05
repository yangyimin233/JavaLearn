package hot100;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE22 {

    // 可能字符串
    // 其实还是回溯问题
    public List<String> generateParenthesis(int n) {


        // 本质上还是 一个travel递归
        // 递归终止条件，当前构造的string 已经达到长度2*n (n层括号，括号总数为6)
        // 然后就是往sring里面塞括号

        List<String> res = new ArrayList<String>();
        tavel(res,n,0,0,new StringBuilder());
        return res;


    }

    private void tavel(List<String> res, int n, int left, int right, StringBuilder sb) {
        // res结果集
        // 这里我们先用 sb 更能体现回溯的思想

        if (sb.length() == 2*n) {
            // 到达长度，把sb转化成字符串 放进结果集
            res.add(sb.toString());
            return;
        }

        // 尝试放入(
        if (left<n){
            sb.append('(');
            tavel(res, n, left+1, right, sb);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }

        if (left>right && right<n){
            // 注意这个条件，右括号不能是直接上，左边一定要有多余的左括号才行
            sb.append(')');
            tavel(res, n, left, right+1, sb);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }

    }


    // 然后是 string版本的，这个每次传入的string都是一个新的，相当于不用做回溯了
    private void tavel2(List<String> res, int n, int left, int right, String s) {
        // res结果集
        // 这里我们先用 sb 更能体现回溯的思想

        if (s.length() == 2*n) {
            // 到达长度，把sb转化成字符串 放进结果集
            res.add(s);
            return;
        }

        // 尝试放入(
        if (left<n){
            tavel2(res, n, left+1, right, s+'(');
        }
        if (left>right && right<n){
            // 注意这个条件，右括号不能是直接上，左边一定要有多余的左括号才行
            tavel2(res, n, left, right+1, s+')');
        }

    }


    // 然后顺带 记忆一下 二叉树所有路径
    private void tavelPath(List<String> res, TreeNode root, StringBuilder path) {

        if (root == null) {
            return;
        }

        // 记录进入前的状态（长度）
        int len = path.length();
        if (len != 0) path.append("->");
        // 前序：加入当前节点
        path.append(root.val);

        // 叶子节点：收集结果
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        }

        // 递归左右子树
        if (root.left != null) {
            tavelPath(res, root.left, path);
        }
        if (root.right != null) {
            tavelPath(res, root.right, path);
        }

        // 然后是回溯
        while (path.length() > len) {
            path.deleteCharAt(path.length() - 1);
        }

    }


    // 是在不行你也可以求一个 List<List<int>> res 然后再手动里面 转化
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
            path.remove(path.size() - 1);
        }




    }





}
