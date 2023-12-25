class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode start = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int res = l1 == null ? 0 : l1.val;
            res += l2 == null ? 0 : l2.val;
            res += carry;
            start.next = new ListNode(res % 10);
            start = start.next;
            carry = res / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}