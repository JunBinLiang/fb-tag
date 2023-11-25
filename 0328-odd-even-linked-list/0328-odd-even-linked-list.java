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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode();
        ListNode dummyEven = new ListNode();
        ListNode curOdd = dummyOdd;
        ListNode curEven = dummyEven;
        
        int i = 1;
        while(head != null) {
            if(i % 2 == 1) {
                curOdd.next = head;
                curOdd = curOdd.next;
                head = head.next;
                curOdd.next = null;
            } else {
                curEven.next = head;
                curEven = curEven.next;
                head = head.next;
                curEven.next = null;
            }
            i++;
        }
        
        curOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
}