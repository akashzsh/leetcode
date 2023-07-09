class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode bigger = new ListNode(0);
        ListNode p1 = smaller, p2 = bigger;
        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
            head = head.next;
        }
        p1.next = bigger.next;
        p2.next = null;
        return smaller.next;
    }
}