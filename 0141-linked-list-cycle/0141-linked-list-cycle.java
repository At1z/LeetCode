/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
        /*if (head == null) {
            return false;
        }
        HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) { 
                return true;  
            }
            seen.add(head);
            head = head.next;
        }
        return false;
        */  
    }
}