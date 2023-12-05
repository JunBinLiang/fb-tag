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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelSize = 1;
        while(q.size() > 0) {
            int sz = q.size();
            boolean hasNull = false;
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                if(u.left != null) {
                    if(hasNull || sz != levelSize) return false;
                    q.add(u.left);
                } else {
                    hasNull = true;
                }
                
                if(u.right != null) {
                    if(hasNull || sz != levelSize) return false;
                    q.add(u.right);
                } else {
                    hasNull = true;
                }
            }
            levelSize *= 2;
        }
        
        return true;
    }
}