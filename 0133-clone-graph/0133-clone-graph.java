/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map;
    Set<Node> set;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        map = new HashMap<>();
        set = new HashSet<>();
        dfs1(node);
        set = new HashSet<>();
        dfs2(node);
        return map.get(node.val);
    }
    
    public void dfs1(Node node) {
        set.add(node);
        map.put(node.val, new Node(node.val));
        for(Node next : node.neighbors) {
            if(!set.contains(next)) {
                dfs1(next);
            }
        }
    }
    
    public void dfs2(Node node) {
        set.add(node);
        for(Node next : node.neighbors) {
            map.get(node.val).neighbors.add(map.get(next.val));
            if(!set.contains(next)) {
                dfs2(next);
            }
        }
    }
}