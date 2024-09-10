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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode output = new ListNode(0);
        ListNode outputCurrent = output;
        ListNode headNext = head;
        int size = 0;
        while(headNext != null){
            size += 1;
            headNext = headNext.next;
        }
        headNext = head.next;
    for (int i = 0; i < size; i++) {
        outputCurrent.next = new ListNode(head.val);
        outputCurrent = outputCurrent.next;  
        if (headNext != null) {
            int gcdI = gcd(head.val, headNext.val);
            outputCurrent.next = new ListNode(gcdI);
            outputCurrent = outputCurrent.next;
            head = head.next;
            headNext = headNext.next;
        }
    }
        return output.next;
    }
    public static int gcd(int a, int b) {   
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}