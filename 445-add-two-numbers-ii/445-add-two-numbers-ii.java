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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseList(l1), head2 = reverseList(l2);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int x = (head1 != null) ? head1.val : 0;
            int y = (head2 != null) ? head2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        return reverseList(head.next);
    }
}