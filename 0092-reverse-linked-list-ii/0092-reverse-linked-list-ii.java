class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode prev = tmp;
        for (int i = 0; i < left - 1; i++) prev = prev.next;
        ListNode slow = prev.next;
        ListNode nextNode;
        for (int i = 0; i < right - left; i++) {
            nextNode = slow.next;
            slow.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return tmp.next;
    }
}