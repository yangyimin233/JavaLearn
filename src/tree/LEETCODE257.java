package tree;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE257 {

//    给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
//    叶子节点 是指没有子节点的节点。


    public static void main(String[] args) {
        String str = "CESS EA";
        setStr(str);
        System.out.println(str);
    }



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // 拼接当前路径
        path += node.val;

        // 如果是叶子节点
        if (node.left == null && node.right == null) {
            result.add(path); // 把完整路径加入结果
            return;
        }

        // 不是叶子节点就继续走子树
        path += "->";
        dfs(node.left, path, result);
        // 这个地方是有点难理解的，你想，你左分支递归完了后，path里面是不是被左分支的点给污染了？毕竟前面会+= node.val 这些？
        // 实际很巧妙的是，这个path传进去的是副本，并不影响当前层的val
        // 这里就不需要回溯了，直接萌萌干就完事了
        dfs(node.right, path, result);
    }


    static void setStr(String str) {
        str += "aaaa";
        // String 比较特殊，它属于不可变引用类型，也就是你传参 str 进入函数，实际上不影响你原来的str
    }


}
