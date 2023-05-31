class Solution {
    public ListNode reverseList(ListNode head) {
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
}