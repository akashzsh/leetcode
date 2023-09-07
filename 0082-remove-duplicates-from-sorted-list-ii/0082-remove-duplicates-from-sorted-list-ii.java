class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = new ListNode(101);
        ListNode cur = head, p = tmp;
        int prev = 101;
        while (cur != null) {
            if (cur.val != prev) {
                if (cur.next == null || cur.next.val != cur.val) {
                    p.next = cur;
                    p = p.next;
                }
            }
            prev = cur.val;
            cur = cur.next;
        }
        p.next = null;
        return tmp.next;
    }
}