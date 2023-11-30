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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(stk.size() > 0) {
            TreeNode u = stk.pop();
            res.add(u.val);
            if(u.left != null) {
                stk.push(u.left);
            }
            if(u.right != null) {
                stk.push(u.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}