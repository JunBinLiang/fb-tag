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
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode res = root;
        while(root != null) {
            stk.push(root);
            res = root;
            root = root.left;
        }
        
        TreeNode pre = null;
        TreeNode cur = res;
        
        while(stk.size() > 0) {
            TreeNode u = stk.pop();
            cur = u;
            u = u.right;
            while(u != null) {
                stk.push(u);
                u = u.left;
            }
            
            if(pre != null) {
                pre.left = null;
                pre.right = cur;
            }
            pre = cur;
        }
        
        cur.left = null;
        cur.right = null;
        return res;
    }
}