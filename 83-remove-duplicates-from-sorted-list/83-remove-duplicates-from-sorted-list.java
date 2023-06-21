class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode curr2 = head;
        int value = curr.val;
        curr2 = curr2.next;
        while (curr2 != null) {
            if (curr2.val != value) {
                value = curr2.val;
                curr.next  = curr2;
                curr = curr2;
                curr2 = curr2.next;
            } else {
                curr2 = curr2.next;
            }
        }
        curr.next = null;
        return head;
    }
}