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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode tail = head;
        for(int i = 0; i < left - 1; i++) {
            pre = cur;
            cur = cur.next;
        }
        
        for(int i = 0; i < right - 1; i++) {
            tail = tail.next;
        }
        
        ListNode next = cur.next;
        while(cur != tail) {
            ListNode nnext = next.next;
            next.next = cur;
            cur = next;
            next = nnext;
        }
        
        pre.next.next = next;
        pre.next = cur;
        
        
        return dummy.next;
    }
}