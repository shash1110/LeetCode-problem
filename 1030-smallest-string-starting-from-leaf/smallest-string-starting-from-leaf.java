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
    private String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        leaf(root, new StringBuilder());
        return ans;
    }
    void leaf(TreeNode root, StringBuilder sb){
        if(root==null) return;
        sb.append((char) (root.val + 'a'));

        if(root.left == null && root.right == null){
            final String path = sb.reverse().toString();
            sb.reverse();
            if (ans == null || ans.compareTo(path) > 0)
                 ans = path;
        }
        leaf(root.left, sb);
        leaf(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}