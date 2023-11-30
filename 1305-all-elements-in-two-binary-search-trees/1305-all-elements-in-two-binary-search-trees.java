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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        
        while(root1 != null) {
            stk1.push(root1);
            root1 = root1.left;
        }
        
        while(root2 != null) {
            stk2.push(root2);
            root2 = root2.left;
        }
        
        while(stk1.size() > 0 && stk2.size() > 0) {
            if(stk1.peek().val > stk2.peek().val) {
                Stack<TreeNode> temp = stk1;
                stk1 = stk2;
                stk2 = temp;
            }
            
            TreeNode u = stk1.pop();
            res.add(u.val);
            u = u.right;
            while(u != null) {
                stk1.push(u);
                u = u.left;
            }
        }
        
        if(stk1.size() == 0) {
            stk1 = stk2;
        }
        
        while(stk1.size() > 0) {
            TreeNode u = stk1.pop();
            res.add(u.val);
            u = u.right;
            while(u != null) {
                stk1.push(u);
                u = u.left;
            }
        }
        
        return res;
    }
}