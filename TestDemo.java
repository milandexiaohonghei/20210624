import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    /**
     *https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * 二叉树的前序遍历
     */
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    /**
     *https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
     * 二叉树的后序遍历
     */
    List<Integer> res1 = new ArrayList<Integer>();
    public List<Integer> postorderTraversal1(TreeNode root) {
        preorder1(root, res1);
        return res;
    }
    public void preorder1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder1(root.left, res1);
        res.add(root.val);
        preorder1(root.right, res1);

    }
    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 二叉树的中序遍历
     */
    List<Integer> res2 = new ArrayList<Integer>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        preorder2(root, res2);
        return res;
    }
    public void preorder2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder2(root.left, res2);
        res.add(root.val);
        preorder2(root.right, res2);

    }
    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    /**
     * https://leetcode-cn.com/problems/same-tree/
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if ((p == null && q != null) ||(q == null && p != null)) {
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    /**
     * 572. 另一个树的子树
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        boolean a = isSubtree(root.left,subRoot);
        if(a == true){
            return true;
        }
        boolean b = isSubtree(root.right,subRoot);
        return b;

    }
    /**
     * 101. 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     *https://leetcode-cn.com/problems/symmetric-tree/
     */
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree == null && rightTree == null){
            return true;

        }
        if(leftTree == null || rightTree == null){
            return false;
        }
        if(leftTree.val != rightTree.val){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);

    }
    /**
     * 110. 平衡二叉树
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }




}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


