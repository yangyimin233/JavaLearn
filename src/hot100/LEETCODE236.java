package hot100;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE236 {
//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode re = root;







        return re;
    }


    // 获取到根节点的所有路径
    public static List<String> getAllPath(TreeNode root) {
        List<String> re = new ArrayList<>();
        StringBuilder path = new StringBuilder();


        dfs(root, re, path);

        return re;
    }


    static void dfs(TreeNode root, List<String> re, StringBuilder path) {

        // 递归处理
        if (root == null) {
            return;
        }

        // 将当前节点加入bulider，并且记录加入之前的builder长度
        int nowlen = path.length();
        path.append(root.val);

        // 遇到叶子节点了
        if (root.left == null && root.right == null) {
            // 将path放入re了
            re.add(path.toString());
            // return前需要将path回溯
            path.setLength(nowlen);
            return;
        }
        // 非叶子节点，继续遍历左右孩子
        path.append("->");
        dfs(root.left, re, path);
        dfs(root.right, re, path);

        // 到这里说明当前节点的左右子树全部遍历完了
        // 同理需要return
        path.setLength(nowlen);
        return;


    }



}
