/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node cur = dummy;
        Node temp = head;
        
        Map<Node, Integer> map1 = new HashMap<>();
        Map<Integer, Node> map2 = new HashMap<>();
        int id = 0;
        
        while(temp != null) {
            Node node = new Node(temp.val);
            cur.next = node;
            map1.put(temp, id);
            map2.put(id, node);
            id++;
            cur = cur.next;
            temp = temp.next;
        }
        
        temp = head;
        cur = dummy.next;
        while(temp != null) {
            if(temp.random != null) {
                int rId = map1.get(temp.random);
                Node rNode = map2.get(rId);
                cur.random = rNode;
            }
            cur = cur.next;
            temp = temp.next;
        }
        
        
        
        
        return dummy.next;
    }
}