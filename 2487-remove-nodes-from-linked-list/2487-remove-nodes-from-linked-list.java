class Solution {
    
    public ListNode reverse(ListNode head) {
        ListNode nextNode, prev = null;
        ListNode slow = head;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        return prev;
    }
    
    public ListNode removeNodes(ListNode head) {
        ListNode current = reverse(head);
        ListNode prev = current;
        while (current != null && current.next != null) {
            if (current.next.val < current.val) {
                current.next = current.next.next;
            } else current = current.next;
        }
        return reverse(prev);
    }
}