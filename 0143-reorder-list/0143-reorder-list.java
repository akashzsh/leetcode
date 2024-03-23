class Solution {
    public ListNode reverse(ListNode cur) {
        ListNode prev = null;
        
        while (cur != null) {
            ListNode front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode partB = reverse(slow.next);
        slow.next = null;
        
        while (head != null && partB != null) {
            ListNode headNext = head.next;
            ListNode partBNext = partB.next;
            
            partB.next = head.next;
            head.next = partB;
            
            head = headNext;
            partB = partBNext;
        }
    }
}