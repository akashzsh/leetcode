class Solution {
    public ListNode merge(ListNode part1, ListNode part2) {
        ListNode dummy = new ListNode(0);
        
        ListNode cur = dummy;
        
        while (part1 != null && part2 != null) {
            if (part1.val < part2.val) {
                cur.next = part1;
                part1 = part1.next;
            } else {
                cur.next = part2;
                part2 = part2.next;
            }
            cur = cur.next;
        }
        
        while (part1 != null) {
            cur.next = part1;
            part1 = part1.next;
            cur = cur.next;
        }
        
        while (part2 != null) {
            cur.next = part2;
            part2 = part2.next;
            cur = cur.next;
        }
        
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode part1 = sortList(head);
        ListNode part2 = sortList(slow);
        
        return merge(part1, part2);
    }
}