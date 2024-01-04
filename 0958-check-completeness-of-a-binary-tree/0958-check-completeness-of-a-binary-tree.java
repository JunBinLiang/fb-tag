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
        while(q.size() > 0) {
            int sz = q.size();
            boolean empty = false;
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                if(u.left == null) {
                    empty = true;
                } else {
                    if(empty) return false;
                    q.add(u.left);
                }
                
                if(u.right == null) {
                    empty = true;
                } else {
                    if(empty) return false;
                    q.add(u.right);
                }
            }
            if(empty) break;
        }
        
        while(q.size() > 0) {
            TreeNode u = q.poll();
            if(u.left != null || u.right != null) return false;
        }
        
        return true;
    }
}