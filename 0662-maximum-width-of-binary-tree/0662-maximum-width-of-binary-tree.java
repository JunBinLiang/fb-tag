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
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int sz = q.size();
            int left = -1, right = -1;
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                int x = map.get(u);
                if(u.left != null) {
                    q.add(u.left);
                    map.put(u.left, x * 2 + 1);
                }
                if(u.right != null) {
                    q.add(u.right);
                    map.put(u.right, x * 2 + 2);
                }
                if(left == -1) left = x;
                right = x;
            }
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}