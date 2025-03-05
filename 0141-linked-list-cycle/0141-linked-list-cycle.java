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
        if (head == null) {
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
    }
}