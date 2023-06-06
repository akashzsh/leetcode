class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, current = head;
        while (current != null && current.next != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            prev = current;
            current = current.next;
        }
        return dummy.next;
    }
}