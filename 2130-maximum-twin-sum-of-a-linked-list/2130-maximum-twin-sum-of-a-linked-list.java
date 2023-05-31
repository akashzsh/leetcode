class Solution {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        int maximum = 0;
        ListNode start = head;
        while (prev != null) {
            maximum = Math.max(maximum, start.val + prev.val);
            start = start.next;
            prev = prev.next;
        }
        return maximum;
    }
}