class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        int position = counter - n;
        current = dummy;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}