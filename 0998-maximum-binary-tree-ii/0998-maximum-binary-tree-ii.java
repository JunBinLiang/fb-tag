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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> nums = dfs(root);
        nums.add(val);
        return build(nums, 0, nums.size() - 1);
    }
    
    public List<Integer> dfs(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<Integer> llist = dfs(root.left);
        List<Integer> rlist = dfs(root.right);
        llist.addAll(list);
        llist.addAll(rlist);
        return llist;
    }
    
    public TreeNode build(List<Integer> nums, int l, int r) {
        if(l > r) {
            return null;
        }
        int max = nums.get(l), index = l;
        for(int i = l; i <= r; i++) {
            if(nums.get(i) > max) {
                max = nums.get(i);
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums.get(index));
        root.left = build(nums, l, index - 1);
        root.right = build(nums, index + 1, r);
        return root;
    }
}