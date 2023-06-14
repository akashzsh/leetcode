class Solution {
    
    public int size(ListNode head) {
        int s = 0;
        while (head != null) {
            s++;
            head = head.next;
        }
        return s;
    }
    
    public ListNode deleteMiddle(ListNode head) {
        int len = size(head), curr = 0;
        if (len == 1) return null;
        int middle = len / 2;
        ListNode current = head;
        while (curr != middle - 1) {
            current = current.next;
            curr++;
        }
        current.next = current.next.next;
        return head;
    }
}