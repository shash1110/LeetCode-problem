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
    Stack<Integer> seen;
    public boolean checkEqualTree(TreeNode root) {
        seen = new Stack<>();
        int total = sum(root);
        seen.pop();
        while(!seen.isEmpty()){
            int pop = seen.pop();
            if(pop *2 == total){
                return true;
            }
        }
        return false;
    }
    public int sum (TreeNode root){
        if(root==null) return 0;
        int l = sum(root.left);
        int r = sum(root.right);
        int curr = l + r + root.val;
        seen.push(curr);

        return seen.peek();
    } 
}