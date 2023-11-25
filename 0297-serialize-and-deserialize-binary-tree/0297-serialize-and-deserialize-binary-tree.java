/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder str = new StringBuilder();
    public String serialize(TreeNode root) {
        dfs(root);
        return str.toString();
    }
    
    public void dfs(TreeNode root) {
        if(root == null) {
            str.append("# ");
            return;
        }
        str.append(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }
    
    class Info {
        TreeNode node;
        int use = 0;
        public Info(TreeNode node, int use) {
            this.node = node;
            this.use = use;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[] = data.split(" ");
        if(values[0].equals("#")) {
            return null;
        }
        Stack<Info> stk = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        stk.push(new Info(root, 0));
        
        for(int i = 1; i < values.length; i++) {
            String s = values[i];
            while(stk.size() > 0 && stk.peek().use == 2) stk.pop();
            if(s.equals("#")) {
                stk.peek().use++;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(s));
                if(stk.peek().use == 0) {
                    stk.peek().node.left = node;
                } else {
                    stk.peek().node.right = node;
                }
                stk.peek().use++;
                stk.push(new Info(node, 0));
            }
        }
        while(stk.size() > 1) stk.pop();
        return stk.peek().node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));