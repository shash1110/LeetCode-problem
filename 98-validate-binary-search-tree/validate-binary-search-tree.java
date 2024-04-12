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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)?true:false;
    }
    static boolean isValidBST(TreeNode A, long min, long max){
        if(A==null) return true;
        if(A.val <= min || A.val >= max) return false;
        return isValidBST(A.left, min, A.val) && isValidBST(A.right, A.val, max);
    }
}