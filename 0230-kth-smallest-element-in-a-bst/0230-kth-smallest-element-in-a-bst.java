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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
        
        while(stk.size() > 0) {
            k--;
            TreeNode u = stk.pop();
            if(k == 0) return u.val;
            
            u = u.right;
            while(u != null) {
                stk.push(u);
                u = u.left;
            }
        }
        
        return -1;
    }
}