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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
        
        while(stk.size() > 0) {
            TreeNode u = stk.pop();
            res.add(u.val);
            if(u.right != null) {
                u = u.right;
                while(u != null) {
                    stk.push(u);
                    u = u.left;
                }
            }
        }
        
        return res;
    }
}