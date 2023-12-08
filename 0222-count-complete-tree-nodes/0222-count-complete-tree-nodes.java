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
    public int countNodes(TreeNode root) {
        TreeNode u = root;
        int h = 0;
        while(u != null) {
            u = u.left;
            h++;
        }
        
        int l = (int)(Math.pow(2, h - 1)), r = (int)(Math.pow(2, h)) - 1;
        int res = 0;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            u = root;
            
            for(int i = h - 2; i >= 0 && u != null; i--) {
                if((mid & (1 << i)) > 0) {
                    u = u.right;
                } else {
                    u = u.left;
                }
            }
            
            if(u == null) {
                r = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        
        return res;
    }
    
}
