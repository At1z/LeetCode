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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> copy = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            copy.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(!copy.isEmpty()){
            if(copy.pop() != temp.val){
                return false;
            }
            temp = temp.next;
        }
        
        return true;
    }
}