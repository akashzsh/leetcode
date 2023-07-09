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
    
    public void reorderList(ListNode head) {        
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverseList(slow.next);
        slow.next = null;
        
        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tmp2;
        }
    }
}