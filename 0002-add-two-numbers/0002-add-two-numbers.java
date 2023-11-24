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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            if(sum >= 10) {
                c = 1;
            } else {
                c = 0;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if(l2 != null) {
            l1 = l2;
        }
        
        while(l1 != null) {
            int sum = l1.val + c;
            if(sum >= 10) {
                c = 1;
            } else {
                c = 0;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }
        
        if(c > 0) {
            ListNode node = new ListNode(c);
            cur.next = node;
        }
        
        return dummy.next;
    }
}