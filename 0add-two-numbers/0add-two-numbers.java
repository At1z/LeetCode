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
        ListNode l3 = new ListNode(0);
        ListNode current = l3;
        int memo = 0;
        while(l1 != null || l2 != null || memo != 0){
            int sum = memo;
            if(l1 != null ){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null ){
                sum += l2.val;
                l2 = l2.next;
            }
            memo = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return l3.next;
    }
}