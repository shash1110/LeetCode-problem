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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        dfs(root, false, ans);

        return ans;
  }

  private void dfs(TreeNode root, boolean isLonely, List<Integer> ans) {
        if (root == null)
            return;
        if (isLonely)
            ans.add(root.val);

        dfs(root.left, root.right == null, ans);
        dfs(root.right, root.left == null, ans);
    }
}