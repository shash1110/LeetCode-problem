

import static java.lang.System.mapLibraryName;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> kids = new HashSet<>();
        Map<Integer, TreeNode> m = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], kid = d[1], left = d[2];
            m.putIfAbsent(parent, new TreeNode(parent));
            m.putIfAbsent(kid, new TreeNode(kid));
            kids.add(kid);
            if (left == 1) {
                m.get(parent).left = m.get(kid);
            }else {
                m.get(parent).right = m.get(kid);
            }
        }
        m.keySet().removeAll(kids);
        return m.values().iterator().next();
    }
}