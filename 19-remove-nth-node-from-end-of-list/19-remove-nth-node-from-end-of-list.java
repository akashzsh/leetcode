class Solution {
    
    public int countNodes(ListNode curr) {
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (countNodes(head) < 2) return null;
        int pos = countNodes(head) - n, curr = 1;
        if (pos == 0) return head.next;
        ListNode tmp = head;
        while (tmp != null && curr <= pos - 1) {
            curr++;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next != null ? tmp.next.next : null;
        return head;
    }
}