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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
       return left(root, false);
    }
    private int left(TreeNode root, boolean isleft){
        if(root==null) return 0;
        if(root.left ==null && root.right ==null){
            return isleft ? root.val :0;
        }
        return left(root.left, true) + left(root.right, false);
    }
}