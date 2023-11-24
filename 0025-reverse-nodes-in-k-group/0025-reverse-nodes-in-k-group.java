/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        
        while(cur != null) {
            ListNode oldCur = cur;
            ListNode next = cur.next;
            ListNode tail = cur;
            for(int i = 0; i < k - 1 && tail != null; i++) {
                tail = tail.next;
            }
            
            if(tail == null) break;
            
            while(cur != tail) {
                ListNode nnext = next.next;
                next.next = cur;
                cur = next;
                next = nnext;
            }
            pre.next = cur;
            oldCur.next = next;
            pre = oldCur;
            cur = next;
        }
        
        return dummy.next;
    }
}